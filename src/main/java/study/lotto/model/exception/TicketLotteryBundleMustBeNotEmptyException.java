package study.lotto.model.exception;

public class TicketLotteryBundleMustBeNotEmptyException extends IllegalArgumentException {
    public TicketLotteryBundleMustBeNotEmptyException(final String message) {
        super(message);
    }
}
