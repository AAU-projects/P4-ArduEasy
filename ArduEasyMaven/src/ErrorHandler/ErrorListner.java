package ErrorHandler;

import ErrorHandler.Errors.ErrorEvent;
import java.util.EventListener;

public interface ErrorListner extends EventListener
{
    void Error(ErrorEvent e);
}
