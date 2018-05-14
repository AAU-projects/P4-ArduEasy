import CodeGeneration.BuildCode;
import ErrorHandler.CustomErrorHandler;
import PrettyPrint.PrettyPrint;
import SymbolTable.BuildSymbolTable;
import TypeChecker.TypeChecker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import AST.*;
import antlr4.*;
import AST.Nodes.*;

public class Program
{
    public static void main(String args[]) throws IOException
    {
        Compile(args);
    }

    private static void Compile(String args[]) throws IOException
    {
        String filePath = "CodeExamples/guideExample.txt"; // test 1
        String outputFile = "Outputs/arduinogeneration.ino";
        CharStream inputStream = CharStreams.fromFileName(filePath);
        ArduEasyLexer lexer = new ArduEasyLexer(inputStream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ErrorHandler.ArduEasyErrorListener.Instance);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ArduEasyParser parser = new ArduEasyParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorHandler.ArduEasyErrorListener.Instance);
        System.out.println();

        RootNode root;

        try
        {
            ArduEasyParser.RContext programContext = parser.r();

            if (ErrorHandler.ArduEasyErrorListener.ErrorsPresent())
            {
                ErrorHandler.ArduEasyErrorListener.PrintErrors();
                System.exit(-1);
            }

            root = (RootNode) new BuildAst().visitR(programContext);

            if (Arrays.asList(args).contains("-P"))
            {
                PrettyPrint printer = new PrettyPrint();
                printer.Visit(root);
            }

            BuildSymbolTable SymbolTable = new BuildSymbolTable();
            SymbolTable.Visit(root);

            TypeChecker typeChecker = new TypeChecker(SymbolTable.symbolTable);

            System.out.println("Type Checker:");
            typeChecker.Visit(root);
            System.out.println("Complete...");

            if (CustomErrorHandler.ErrorsPresent() && !Arrays.asList(args).contains("-FG")){
                CustomErrorHandler.PrintErrors();System.exit(-1);}

            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
            System.out.println();
            System.out.println("Code Generation:");
            System.out.println();
            BuildCode CodeGenerator = new BuildCode(writer);
            //CodeGenerator.Visit(root);
            writer.close();
            System.out.println("Code Generation Complete...");


            CustomErrorHandler.PrintErrors();

        } catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            CustomErrorHandler.PrintErrors();
        }
    }
}