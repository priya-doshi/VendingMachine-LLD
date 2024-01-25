package exception;

public class ItemSoldOutException extends ServiceException{
    public ItemSoldOutException(String message){
        super(message);
    }
}
