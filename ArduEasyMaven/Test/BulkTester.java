import AST.BuildAst;
import AST.Nodes.RootNode;
import CodeGeneration.BuildCode;
import ErrorHandler.CustomErrorHandler;
import ErrorHandler.Errors.ErrorEvent;
import PrettyPrint.PrettyPrint;
import SymbolTable.BuildSymbolTable;
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

    public boolean printErrors = false;
    private HashMap<String, String> testMap = new HashMap<String, String>();

    BulkTester()
    {
        File directory = new File("Test/Testfiles");
        String [] directoryContents = directory.list();
        
        List<String> fileLocations = new ArrayList<String>();

        for (String directoryContent : directoryContents)
        {
            testMap.put(directoryContent.replaceAll(".arz", ""), "Test/Testfiles/" + directoryContent);
        }
    }

    public boolean Start() throws  IOException
    {
        String filePath = "Test/TestFiles/TypeCheckerArrayDecTest.arz"; // test 1

        CharStream inputStream = CharStreams.fromFileName(filePath);
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

            System.out.println("Started testing of code example.");
            ArrayList<Integer> expectedErrors = GetErrors(filePath);
            CheckTest(expectedErrors);

            System.out.println("Successfully tested code example.");

            if (printErrors)
                CustomErrorHandler.PrintErrors();

            return true;

        } catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

    private void CheckTest(ArrayList<Integer> expectedErrors) {
        List<Integer> errorsTypeChecker = CustomErrorHandler.GetLinenumberErrors();

        for (Integer errorTypeChecker : errorsTypeChecker) {
            if (!expectedErrors.contains(errorTypeChecker))
            {
                System.out.println("An error at line " + errorTypeChecker + " is NOT expected but one is found");
            }
        }

        for (Integer expectedError : expectedErrors) {
            if (!errorsTypeChecker.contains(expectedError))
            {
                System.out.println("An error at line " + expectedError + " is expected but error not found");
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
