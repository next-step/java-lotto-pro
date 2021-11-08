package lotto.exception;

public class WrongLottoNumberSizeException extends RuntimeException {
    private static final long serialVersionUID = 4L;
    public WrongLottoNumberSizeException(String message) {
        super(message);
    }
}
