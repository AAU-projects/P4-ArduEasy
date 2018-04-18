package ErrorHandler.Errors;

import AST.Nodes.Node;

public class SemanticError extends ErrorEvent
{
    public SemanticError(Node source)
    {
        super(source);
    }

    public SemanticError(Node source, String message)
    {
        super(source, message);
    }
}
