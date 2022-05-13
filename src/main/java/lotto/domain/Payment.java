package lotto.domain;

import java.util.Objects;

public class Payment {
    private static final int LOTTO_TICKET_COST = 1000;

    private final int money;
    private final int purchasableAmount;

    public Payment(final String money) {
        this.money = validateMoney(money);
        purchasableAmount = this.money / LOTTO_TICKET_COST;
    }

    private static int validateMoney(final String moneyString) throws IllegalArgumentException {
        final int money = Integer.parseInt(moneyString);
        checkAmount(money);
        return money;
    }

    private static void checkAmount(final int money) {
        if (money <= 0 || money % LOTTO_TICKET_COST != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

    public int getPurchasableAmount() {
        return purchasableAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "money=" + money +
                ", purchasableAmount=" + purchasableAmount +
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
        return money == payment.money && purchasableAmount == payment.purchasableAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, purchasableAmount);
    }
}
