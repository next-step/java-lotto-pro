package lotto.domain.number;

import lotto.exception.OutOfBoundException;

public class Payment extends Money {
    public static final int MINIMUM_MONEY = 1000;

    protected Payment(final int payment) {
        super(payment);
        validate(payment);
    }

    public static Payment from(int payment) {
        return new Payment(payment);
    }

    @Override
    protected void validate(final int payment) {
        if (payment < MINIMUM_MONEY) {
            throw OutOfBoundException.valueIsLessThan(payment);
        }
    }

    public int numberOfAvailableTickets() {
        return number() / MINIMUM_MONEY;
    }
}
