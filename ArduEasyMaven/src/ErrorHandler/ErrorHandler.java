package ErrorHandler;

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
        printErorr(e);
    }

    private static void printErorr(ErrorEvent e)
    {
        System.out.println(e.Message);
    }

    public static void PrintErorrs()
    {
        for (ErrorEvent error : errors)
        {
            printErorr(error);
        }
    }
}
