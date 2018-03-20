import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import Nodes.*;

public class Program
{
    public static void main(String args[]) throws IOException
    {
        String filePath = "CodeExamples/if.txt";
        CharStream inputStream = CharStreams.fromFileName(filePath);
        ArduEasyLexer lexer = new ArduEasyLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ArduEasyParser parser = new ArduEasyParser(tokenStream);
        parser.setBuildParseTree(true);

        ParseTree tree = parser.r();
        TestListener test = new TestListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(test, tree);
        //TestVisitor test = new TestVisitor();
        //test.visit(tree);
    }
}