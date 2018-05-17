import AST.BuildAst;
import AST.Nodes.RootNode;
import CodeGeneration.BuildCode;
import ErrorHandler.CustomErrorHandler;
import ErrorHandler.Errors.ErrorEvent;
import PrettyPrint.PrettyPrint;
import SymbolTable.BuildSymbolTable;
import SymbolTable.SymbolTable;
import TypeChecker.TypeChecker;
import antlr4.ArduEasyLexer;
import antlr4.ArduEasyParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.xml.sax.ErrorHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BulkTester
{
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public boolean printErrors = false;
    private HashMap<String, String> testMap = new HashMap<String, String>();

    public void RunTestCases() throws IOException
    {
        File[] directories = new File("Test").listFiles(new FileFilter()
        {
            @Override
            public boolean accept(File pathname)
            {
                return pathname.isDirectory();
            }
        });

        for (File folder : directories)
        {
            System.out.println(ANSI_YELLOW + "Starting: " + folder.getName() + ANSI_RESET);
            File testDirectory = new File(folder.getPath());
            String[] testDirectories = testDirectory.list();
            for (String directory : testDirectories)
            {
                System.out.println(ANSI_YELLOW + "Starting test: " + directory + ANSI_RESET);
                Start(folder.getPath() + "\\" + directory);
                testMap.put(directory, folder.getPath() + "\\" + directory);
                System.out.println(ANSI_CYAN + "Successfully tested: " + directory + ANSI_RESET);
            }
        }
    }

    public boolean Start(String testPath) throws  IOException
    {
        CharStream inputStream = CharStreams.fromFileName(testPath);
        ArduEasyLexer lexer = new ArduEasyLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ArduEasyParser parser = new ArduEasyParser(tokenStream);

        RootNode root;

        try
        {
            ArduEasyParser.RContext programContext = parser.r();
            root = (RootNode) new BuildAst().visitR(programContext);

            BuildSymbolTable SymbolTable = new BuildSymbolTable();
            SymbolTable.Visit(root);

            TypeChecker typeChecker = new TypeChecker(SymbolTable.symbolTable);
            typeChecker.Visit(root);

            ArrayList<Integer> expectedErrors = GetErrors(testPath);
            CheckTest(expectedErrors);


            if (printErrors)
                CustomErrorHandler.PrintErrors();

            return true;

        } catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
        finally
        {
            // Clears static lists for next test case
            SymbolTable.FunctionList.clear();
            CustomErrorHandler.ClearErrorList();
        }
    }

    private void CheckTest(ArrayList<Integer> expectedErrors) {
        List<Integer> errorsTypeChecker = CustomErrorHandler.GetLinenumberErrors();

        for (Integer errorTypeChecker : errorsTypeChecker) {
            if (!expectedErrors.contains(errorTypeChecker))
            {
                System.out.println(ANSI_RED + "An error at line " + errorTypeChecker + " is NOT expected but one is found" + ANSI_RESET);
            }
        }

        for (Integer expectedError : expectedErrors) {
            if (!errorsTypeChecker.contains(expectedError))
            {
                System.out.println(ANSI_RED + "An error at line " + expectedError + " is expected but error not found" + ANSI_RESET);
            }
        }

    }

    private ArrayList<Integer> GetErrors(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        ArrayList<Integer> expectedErrors = new ArrayList<Integer>();

        String lineRead;
        int lineNumber = 0;

        while ((lineRead = br.readLine()) != null)   {
            ++lineNumber;
            if (lineRead.contains("// error"))
            {
                expectedErrors.add(lineNumber);
            }
        }

        return expectedErrors;
    }
}
