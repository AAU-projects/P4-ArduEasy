package ErrorHandler.Errors;

import AST.Nodes.Node;

public class GenerationError extends ErrorEvent
{
    public GenerationError(Node source)
    {
        super(source);
    }

    public GenerationError(Node source, String message)
    {
        super(source, message);
    }
}
