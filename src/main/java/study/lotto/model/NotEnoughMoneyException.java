package study.lotto.model;

public class NotEnoughMoneyException extends IllegalArgumentException {
    public NotEnoughMoneyException(final String message) {
        super(message);
    }
}
