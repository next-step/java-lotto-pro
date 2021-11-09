package study.lotto.model.exception;

public class IllegalTicketOrderCountException extends IllegalArgumentException {
    public IllegalTicketOrderCountException(final String message) {
        super(message);
    }
}
