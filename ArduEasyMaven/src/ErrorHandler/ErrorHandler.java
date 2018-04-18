package ErrorHandler;

import AST.Nodes.Node;
import ErrorHandler.Errors.ErrorEvent;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler
{
    private static List<ErrorEvent> errors = new ArrayList<ErrorEvent>();

    private static ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
            .foreground(Ansi.FColor.RED).build();

    public static void AddError(ErrorEvent e)
    {
        errors.add(e);
    }

    public static void FireInstantError(ErrorEvent e)
    {
        AddError(e);
        printErorr(e);
    }

    private static void printErorr(ErrorEvent e)
    {
        Node s = (Node) e.getSource();
        System.out.println("Error at line " + s.LineNumber + "\n" + e.Message + " @ " + e.getSource());
    }

    public static void PrintErorrs()
    {
        cp.println("hello");
        for (ErrorEvent error : errors)
        {
            printErorr(error);
        }
    }
}
