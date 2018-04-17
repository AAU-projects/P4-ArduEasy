package ErrorHandler.Errors;

public class SyntaxError extends ErrorEvent
{
    public SyntaxError(Object source)
    {
        super(source);
    }

    public SyntaxError(Object source, String message)
    {
        super(source, message);
    }
}
