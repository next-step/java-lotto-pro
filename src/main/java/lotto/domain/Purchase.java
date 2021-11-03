package lotto.domain;

import java.util.Objects;

public class Purchase {

    private final int price;

    public Purchase(int price) {
        this.price = price;
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
