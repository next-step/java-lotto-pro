package lotto.vo;

import java.util.Objects;

public class Money {
    private final static String NEGATIVE_AMOUNTS_OR_ZERO_CANNOT_BE_ENTERED = "1원 보다 작은 금액은 입력할 수 없습니다.";

    private int money;

    public Money(int money) {
        if (money < 1) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNTS_OR_ZERO_CANNOT_BE_ENTERED);
        }
        this.money = money;
    }

    public int value() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }
}
