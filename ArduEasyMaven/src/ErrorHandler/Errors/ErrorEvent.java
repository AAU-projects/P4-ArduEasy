package ErrorHandler.Errors;

import AST.Nodes.Node;

import java.util.EventObject;

public abstract class ErrorEvent extends EventObject
{
    public final String Message;
    public int LineNumber;

    public ErrorEvent(Node source)
    {
        super(source);
        Message = "";
    }

    public ErrorEvent(Node source, String message)
    {
        super(source);
        Message = message;
        LineNumber = source.LineNumber;
    }
}
