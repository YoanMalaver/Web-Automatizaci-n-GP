package exceptions;

public class CaseFailedException extends Error {
    public CaseFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaseFailedException(String messageFailed) {
        super(messageFailed);
    }
}
