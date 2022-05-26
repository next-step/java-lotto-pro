package lotto.domain;

import lotto.message.InputMessage;

public class ManualNumber {
    private static final int MINIMUM = 0;
    private final int manual;

    public ManualNumber(int manual) {
        validateManual(manual);
        this.manual = manual;
    }

    public ManualNumber(int manual, Money money) {
        validateManual(manual);
        validateMoney(manual, money);
        this.manual = manual;
    }

    private void validateMoney(int manual, Money money) {
        if (manual > money.ticketCount()) {
            throw new IllegalArgumentException(InputMessage.INVALID_MANUAL_RANGE);
        }
    }

    private void validateManual(int manual) {
        if (manual < MINIMUM) {
            throw new IllegalArgumentException(InputMessage.INVALID_MANUAL_MINIMUM);
        }
    }
}
