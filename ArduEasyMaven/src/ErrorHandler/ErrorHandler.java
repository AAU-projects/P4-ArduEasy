package ErrorHandler;

import AST.Nodes.Node;
import ErrorHandler.Errors.ErrorEvent;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler
{
    private static List<ErrorEvent> errors = new ArrayList<ErrorEvent>();

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

    private static void printErorr(ErrorEvent e)
    {
        Node s = (Node) e.getSource();
        System.out.println("\u001B[31mError at line " + s.LineNumber + "\n" + e.Message + " @ " + e.getSource());
    }

    public static void PrintErrors()
    {
        for (ErrorEvent error : errors)
        {
            printErorr(error);
        }
    }
}
