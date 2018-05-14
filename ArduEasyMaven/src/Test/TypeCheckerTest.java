package Test;

import AST.BuildAst;
import AST.Nodes.RootNode;
import CodeGeneration.BuildCode;
import ErrorHandler.ErrorHandler;
import ErrorHandler.Errors.ErrorEvent;
import PrettyPrint.PrettyPrint;
import SymbolTable.BuildSymbolTable;
import TypeChecker.TypeChecker;
import antlr4.ArduEasyLexer;
import antlr4.ArduEasyParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeCheckerTest
{
    public TypeCheckerTest() throws IOException
    {
    }

    public boolean Start() throws  IOException
    {
        String filePath = "src/Test/TestFiles/AssigmentDeclaration.txt"; // test 1

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

            ArrayList<Integer> expectedErrors = GetErrors(filePath);
            CheckTest(expectedErrors);

            return true;

        } catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

    private void CheckTest(ArrayList<Integer> expectedErrors) {
        List<Integer> errorsTypeChecker = ErrorHandler.GetLinenumberErrors();

        for (Integer errorTypeChecker : errorsTypeChecker) {
            if (!expectedErrors.contains(errorTypeChecker))
            {
                System.out.println("Test of type checker error at " + errorTypeChecker + " is NOT expected");
            }
        }

        for (Integer expectedError : expectedErrors) {
            if (!errorsTypeChecker.contains(expectedError))
            {
                System.out.println("Test of type checker error at " + expectedError + " is expected");
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
