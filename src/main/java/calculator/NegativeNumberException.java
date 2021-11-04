package calculator;

public class NegativeNumberException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NegativeNumberException(String message) {
        super(message);
    }
}
