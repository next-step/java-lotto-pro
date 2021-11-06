package study.lotto.model;

public class TicketLotteryBundleMustBeNotEmptyException extends IllegalArgumentException {
    public TicketLotteryBundleMustBeNotEmptyException(final String message) {
        super(message);
    }
}
