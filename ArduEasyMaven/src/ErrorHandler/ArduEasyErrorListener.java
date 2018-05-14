package ErrorHandler;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class ArduEasyErrorListener extends BaseErrorListener
{
    public static final ArduEasyErrorListener Instance = new ArduEasyErrorListener();
    private static List<String> errors = new ArrayList<String>();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int lineNumber, int charPositionInLine, String message, RecognitionException e)
    {
        errors.add(ANSI_RED + "SYNTAX ERROR: at line " + lineNumber + " MESSAGE: " + message + ANSI_RESET);
    }

    public static boolean ErrorsPresent(){return errors.size()>0;}

    public static void PrintErrors()
    {
        for (String error : errors)
        {
            System.out.println(error);
        }
    }
}
