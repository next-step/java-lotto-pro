package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final double money;

    public Money(String money) {
        this(Double.parseDouble(money));
    }

    public Money(double money) {
        validate(money);
        this.money = money;
    }

    private void validate(double money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("금액이 부족합니다.(최소필요금액: %d)", LOTTO_PRICE));
        }
    }

    public int getQuantity() {
        return (int) (this.money / LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Double.compare(money1.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return Double.toString(money);
    }
}
