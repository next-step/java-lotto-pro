package exception;

public class NotPositiveNumberException extends NumberFormatException {
    public NotPositiveNumberException(String s) {
        super(s);
    }
}
