package study.lotto.model;

public class IllegalLotterySizeException extends IllegalArgumentException {
    public IllegalLotterySizeException(final String message) {
        super(message);
    }
}
