package ErrorHandler;

import AST.Nodes.Node;
import ErrorHandler.Errors.ErrorEvent;

import java.util.ArrayList;
import java.util.List;

public class CustomErrorHandler
{
    private static List<ErrorEvent> errors = new ArrayList<ErrorEvent>();

    public static boolean ErrorsPresent(){return errors.size()>0;}

    public static void AddError(ErrorEvent e)
    {
        errors.add(e);
    }

    public static void FireInstantError(ErrorEvent e)
    {
        AddError(e);
        PrintErrors();
        System.exit(-1);
    }

    private static void printError(ErrorEvent e)
    {
        Node s = (Node) e.getSource();
        System.out.println("\u001B[31mError at line " + s.LineNumber + " @ " + e.getSource() + "\n" + e.Message );
    }

    public static void PrintErrors()
    {
        for (ErrorEvent error : errors)
        {
            printError(error);
        }
    }
}
