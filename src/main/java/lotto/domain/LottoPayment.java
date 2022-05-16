package lotto.domain;

import static lotto.domain.message.ErrorMessage.INVALID_PAYMENT;

import java.util.Objects;

public class LottoPayment {
    private static final int LOTTO_TICKET_COST = 1000;

    private final int money;
    private final int purchasableAmount;

    public LottoPayment(final String money) {
        this.money = validateMoney(money);
        purchasableAmount = this.money / LOTTO_TICKET_COST;
    }

    private static int validateMoney(final String moneyString) {
        final int money = Integer.parseInt(moneyString);
        checkAmount(money);
        return money;
    }

    private static void checkAmount(final int money) {
        if (money <= 0 || money % LOTTO_TICKET_COST != 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT.getMessage());
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
        final LottoPayment lottoPayment = (LottoPayment) o;
        return money == lottoPayment.money && purchasableAmount == lottoPayment.purchasableAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, purchasableAmount);
    }
}
