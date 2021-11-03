package lotto.domain;

import java.util.Objects;

public class Purchase {

    private static final int ZERO = 0;

    private final int price;

    public Purchase(final int price) {
        check(price);
        this.price = price;
    }

    private void check(int price) {
        if (price < ZERO) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return price == purchase.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
