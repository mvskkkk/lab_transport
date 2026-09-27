package by.bsu.exception;

public class InvalidPassengerRangeException extends Exception{

    public InvalidPassengerRangeException() {
    }

    public InvalidPassengerRangeException(String message) {
        super(message);
    }

    public InvalidPassengerRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPassengerRangeException(Throwable cause) {
        super(cause);
    }

    public InvalidPassengerRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
