package lotto.domain;

import lotto.domain.exception.LeakOfPaymentException;

public final class Payment {

    private static final int LOTTO_PRICE = 1_000;

    private final int payment;

    private Payment(final int payment) {
        this.payment = payment;
    }

    public static Payment from(final int payment) {
        validate(payment);
        return new Payment(payment);
    }

    private static void validate(final int payment) {
        if (payment < LOTTO_PRICE) {
            throw new LeakOfPaymentException();
        }
    }

}
