package study.lotto.model.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {
    public NotEnoughMoneyException(final String message) {
        super(message);
    }
}
