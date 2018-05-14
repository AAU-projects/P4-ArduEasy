import CodeGeneration.BuildCode;
import ErrorHandler.ErrorHandler;
import PrettyPrint.PrettyPrint;
import SymbolTable.BuildSymbolTable;
import TypeChecker.TypeChecker;
import org.antlr.v4.runtime.ANTLRErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import AST.*;
import antlr4.*;
import AST.Nodes.*;
import visitor.Visitor;

public class Program
{
    public static void main(String args[]) throws IOException
    {
        String filePath = "CodeExamples/AssigmentDeclaration.txt"; // test 1
        // String filePath = "CodeExamples/syntaxValidOperators.txt"; // test 2
        String outputFile = "Outputs/arduinogeneration.ino";
        CharStream inputStream = CharStreams.fromFileName(filePath);
        ArduEasyLexer lexer = new ArduEasyLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ArduEasyParser parser = new ArduEasyParser(tokenStream);
        System.out.println();

        RootNode root;

        try
        {
            ArduEasyParser.RContext programContext = parser.r();

            root = (RootNode) new BuildAst().visitR(programContext);

            if (Arrays.asList(args).contains("-P"))
            {

            }

            PrettyPrint printer = new PrettyPrint();
            //printer.Visit(root);

            BuildSymbolTable SymbolTable = new BuildSymbolTable();
            SymbolTable.Visit(root);

            TypeChecker typeChecker = new TypeChecker(SymbolTable.symbolTable);

            System.out.println("Type Checker:");
            typeChecker.Visit(root);
            System.out.println("Complete...");

            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
            System.out.println();
            System.out.println("Code Generation:");
            System.out.println();
            BuildCode CodeGenerator = new BuildCode(writer);
            //CodeGenerator.Visit(root);
            writer.close();
            System.out.println("Code Generation Complete...");


            ErrorHandler.PrintErrors();

        } catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            ErrorHandler.PrintErrors();
        }

    }
}