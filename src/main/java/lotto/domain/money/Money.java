package lotto.domain.money;

import lotto.status.ErrorStatus;

import java.util.Objects;

public class Money {

    private static final int MIN_AMOUNT = 0;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_MONEY_AMOUNT.getMessage());
        }
    }

    private boolean isPossibleBuyLotto(int price) {
        return this.amount >= price;
    }

    public int possibleBuyLottoCount(int price) {
        if (!isPossibleBuyLotto(price)) {
            throw new RuntimeException(ErrorStatus.CAN_NOT_PURCHASE_LOTTO.getMessage());
        }
        return Math.floorDiv(amount, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
