package lotto.exception;

public class MinimumTicketPriceException extends RuntimeException {
    private static final long serialVersionUID = 3L;

    public MinimumTicketPriceException(String message) {
        super(message);
    }
}
