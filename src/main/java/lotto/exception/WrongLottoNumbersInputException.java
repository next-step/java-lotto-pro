package lotto.exception;

public class WrongLottoNumbersInputException extends Exception {
    private static final long serialVersionUID = 5L;

    public WrongLottoNumbersInputException(String message) {
        super(message);
    }
}
