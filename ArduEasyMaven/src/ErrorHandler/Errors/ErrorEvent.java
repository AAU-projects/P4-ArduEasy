package ErrorHandler.Errors;

import AST.Nodes.Node;

import java.util.EventObject;

public abstract class ErrorEvent extends EventObject
{
    public final String Message;

    public ErrorEvent(Object source)
    {
        super(source);
        Message = "";
    }

    public ErrorEvent(Object source, String message)
    {
        super(source);
        Message = message;
    }
}
