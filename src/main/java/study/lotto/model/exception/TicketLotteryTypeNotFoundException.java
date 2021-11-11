package study.lotto.model.exception;

public class TicketLotteryTypeNotFoundException extends IllegalArgumentException {
    public TicketLotteryTypeNotFoundException(final String message) {
        super(message);
    }
}
