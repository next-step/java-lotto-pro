package lotto.domain;

import lotto.domain.exception.LeakOfPaymentException;

import java.util.Objects;

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

    public Payment spend(int spendCount) {
        return new Payment(payment - (LOTTO_PRICE * spendCount));
    }

    private static void validate(final int payment) {
        if (payment < LOTTO_PRICE) {
            throw new LeakOfPaymentException();
        }
    }

    public int getTryCount() {
        return payment / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment1 = (Payment) o;
        return payment == payment1.payment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment);
    }

}
