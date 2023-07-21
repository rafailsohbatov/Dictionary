package exception;

public class WordNotFoundException extends RuntimeException{
    String message;

    public WordNotFoundException(String message){
        super(message);
    }
}
