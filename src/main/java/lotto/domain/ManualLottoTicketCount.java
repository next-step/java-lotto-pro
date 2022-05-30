package lotto.domain;

import lotto.message.InputMessage;

public class ManualLottoTicketCount {
    private static final int MINIMUM = 0;
    private final int ticketCount;

    public ManualLottoTicketCount(int ticketCount) {
        validateManual(ticketCount);
        this.ticketCount = ticketCount;
    }

    public ManualLottoTicketCount(int ticketCount, Money money) {
        validateManual(ticketCount);
        validateMoney(ticketCount, money);
        this.ticketCount = ticketCount;
    }

    private void validateMoney(int ticketCount, Money money) {
        if (ticketCount > money.ticketCount()) {
            throw new IllegalArgumentException(InputMessage.INVALID_MANUAL_RANGE);
        }
    }

    private void validateManual(int ticketCount) {
        if (ticketCount < MINIMUM) {
            throw new IllegalArgumentException(InputMessage.INVALID_MANUAL_MINIMUM);
        }
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
