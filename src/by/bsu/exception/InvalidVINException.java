package by.bsu.exception;

public class InvalidVINException extends Exception{
    public InvalidVINException(){
        super();
    }
    public InvalidVINException(String message){
        super();
    }

    public InvalidVINException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVINException(Throwable cause) {
        super(cause);
    }

    public InvalidVINException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
