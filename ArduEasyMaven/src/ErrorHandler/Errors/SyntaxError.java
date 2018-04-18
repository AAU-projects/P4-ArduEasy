package ErrorHandler.Errors;

import AST.Nodes.Node;

public class SyntaxError extends ErrorEvent
{
    public SyntaxError(Node source)
    {
        super(source);
    }

    public SyntaxError(Node source, String message)
    {
        super(source, message);
    }
}
