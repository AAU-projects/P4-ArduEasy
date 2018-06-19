import CodeGeneration.BuildCode;
import ErrorHandler.CustomErrorHandler;
import PrettyPrint.PrettyPrint;
import SymbolTable.BuildSymbolTable;
import TypeChecker.TypeChecker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
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
        if (Arrays.asList(args).contains("-T"))
        {
            BulkTester bulkTester = new BulkTester();

            if (Arrays.asList(args).contains("-PE"))
                bulkTester.printErrors = true;

            bulkTester.RunTestCases();
        }
        else
            Compile(args);
    }

    private static void Compile(String args[])
    {
        String filePath;
        File outputFile;

        try
        {
            filePath = "CodeExamples/project.arz";
            File temp = new File(filePath);

            //String[] temp = filePath.split("\\\\");
            //temp = temp[temp.length-1].split("\\.");
            outputFile = new File("Outputs/" + temp.getName().split("\\.")[0] + "/" + temp.getName().split("\\.")[0] + ".ino");
            //noinspection ResultOfMethodCallIgnored
            outputFile.getParentFile().mkdirs();

            // Initialize charstream from file
            CharStream inputStream = CharStreams.fromFileName(filePath);
            // Initialize lexer with charstream
            ArduEasyLexer lexer = new ArduEasyLexer(inputStream);
            // Remove standard error listeners and add custom ArduEasy listener
            lexer.removeErrorListeners();
            lexer.addErrorListener(ErrorHandler.ArduEasyErrorListener.Instance);
            // Get tokens from lexer
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            // Initialize parser with tokens
            ArduEasyParser parser = new ArduEasyParser(tokenStream);
            //Remove standard error listeners and add custom ArduEasy listener
            parser.removeErrorListeners();
            parser.addErrorListener(ErrorHandler.ArduEasyErrorListener.Instance);

            RootNode root;

            System.out.println("Parsing code");
            ArduEasyParser.RContext programContext = parser.r();
            System.out.println("Complete...");

            // If any errors, print and exit
            if (ErrorHandler.ArduEasyErrorListener.ErrorsPresent())
            {
                ErrorHandler.ArduEasyErrorListener.PrintErrors();
                System.exit(-1);
            }

            System.out.println("AST");
            root = (RootNode) new BuildAst().visitR(programContext);
            System.out.println("Complete...");

            if (Arrays.asList(args).contains("-P"))
            {
                PrettyPrint printer = new PrettyPrint();
                printer.Visit(root);
            }

            System.out.println("Symbol Table & Scopes");
            BuildSymbolTable SymbolTable = new BuildSymbolTable();
            SymbolTable.Visit(root);
            System.out.println("Complete...");


            TypeChecker typeChecker = new TypeChecker(SymbolTable.symbolTable);

            System.out.println("Type Checker:");
            typeChecker.Visit(root);
            System.out.println("Complete...");

            // If any errors, print and exit if not forced gen
            if (CustomErrorHandler.ErrorsPresent() && !Arrays.asList(args).contains("-FG")){
                CustomErrorHandler.PrintErrors();System.exit(-1);}

            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
            System.out.println("Code Generation:");
            BuildCode CodeGenerator = new BuildCode(writer);
            CodeGenerator.Visit(root);
            writer.close();
            System.out.println("Complete...");
            System.out.println("Successfully compiled file into: " + outputFile.getPath());


            CustomErrorHandler.PrintErrors();


        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("No input file given");
            System.exit(0);
        }  catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            CustomErrorHandler.PrintErrors();
        }
    }
}