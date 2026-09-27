package by.bsu.exception;

public class InvalidYearOfReleaseException extends Exception{
    public InvalidYearOfReleaseException(){
        super();
    }
    public InvalidYearOfReleaseException(String message){
        super();
    }

    public InvalidYearOfReleaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidYearOfReleaseException(Throwable cause) {
        super(cause);
    }

    public InvalidYearOfReleaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
