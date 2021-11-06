package study.lotto.model.exception;

public class IllegalLotterySizeException extends IllegalArgumentException {
    public IllegalLotterySizeException(final String message) {
        super(message);
    }
}
