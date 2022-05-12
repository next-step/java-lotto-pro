package lotto.domain;

import java.util.Objects;

public class Payment {
    private final int money;

    public Payment(final String money) {
        this.money = validateMoney(money);
    }

    private static int validateMoney(final String moneyString) throws IllegalArgumentException {
        final int money = Integer.parseInt(moneyString);
        checkAmount(money);
        return money;
    }

    private static void checkAmount(final int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Payment{" +
                "money=" + money +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Payment payment = (Payment) o;
        return money == payment.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
