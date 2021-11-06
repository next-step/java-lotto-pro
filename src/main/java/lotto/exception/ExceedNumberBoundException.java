package lotto.exception;

public class ExceedNumberBoundException extends RuntimeException {
    private static final long serialVersionUID = 2L;
    public ExceedNumberBoundException(String message) {
        super(message);
    }
}
