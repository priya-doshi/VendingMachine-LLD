package exception;

public class InvalidCodeException extends ServiceException{
    public InvalidCodeException(String message){
        super(message);
    }
}
