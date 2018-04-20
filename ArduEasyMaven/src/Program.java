import ErrorHandler.ErrorHandler;
import PrettyPrint.PrettyPrint;
import SymbolTable.BuildSymbolTable;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;
import java.util.Arrays;

import AST.*;
import antlr4.*;
import AST.Nodes.*;

public class Program
{
    public static void main(String args[]) throws IOException
    {
        String filePath = "CodeExamples/guideExample.txt";
        CharStream inputStream = CharStreams.fromFileName(filePath);
        ArduEasyLexer lexer = new ArduEasyLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ArduEasyParser parser = new ArduEasyParser(tokenStream);

        RootNode root;

        try
        {
            ArduEasyParser.RContext programContext = parser.r();

            root = (RootNode) new BuildAst().visitR(programContext);

            if (Arrays.asList(args).contains("-P"))
            {
                PrettyPrint printer = new PrettyPrint();
                printer.Visit(root);
            }

            BuildSymbolTable SymbolTable = new BuildSymbolTable();
            SymbolTable.Visit(root);

            ErrorHandler.PrintErrors();


        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}