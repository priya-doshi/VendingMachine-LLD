package exception;

public class ItemAlreadyPresentException extends ServiceException{
    public ItemAlreadyPresentException(String message){
        super(message);
    }
}
