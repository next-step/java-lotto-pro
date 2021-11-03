package lotto.domain;

import java.util.Objects;

public class Money {

    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public Money(final int price) {
        check(price);
        this.price = price;
    }

    private void check(int price) {
        if (price < ZERO) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }
    }

    public int buy() {
        return price / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money purchase = (Money) o;
        return price == purchase.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
