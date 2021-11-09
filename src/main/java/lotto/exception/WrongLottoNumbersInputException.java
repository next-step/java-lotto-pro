package lotto.exception;

public class WrongLottoNumbersInputException extends RuntimeException {
    private static final long serialVersionUID = 5L;

    public WrongLottoNumbersInputException(String message) {
        super(message);
    }
}
