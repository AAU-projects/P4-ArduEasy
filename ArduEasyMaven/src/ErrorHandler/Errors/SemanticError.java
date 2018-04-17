package ErrorHandler.Errors;

public class SemanticError extends ErrorEvent
{
    public SemanticError(Object source)
    {
        super(source);
    }

    public SemanticError(Object source, String message)
    {
        super(source, message);
    }
}
