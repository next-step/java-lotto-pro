package lotto;

import java.util.Objects;

public class Rank {
    private final int key;
    private final int price;
    private int count;

    public Rank(int key, int price, int count) {
        this.key = key;
        this.price = price;
        this.count = count;
    }

    public void addCount() {
        count++;
    }

    public int calculateTotalPrice() {
        return price * count;
    }

    public int getKey() {
        return key;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rank)) {
            return false;
        }
        Rank rank = (Rank) o;
        return key == rank.key && price == rank.price && count == rank.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, price, count);
    }
}