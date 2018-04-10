package ErrorHandler.Errors;

import java.util.EventObject;

public abstract class ErrorEvent extends EventObject
{
    public ErrorEvent(Object source)
    {
        super(source);
    }
}
