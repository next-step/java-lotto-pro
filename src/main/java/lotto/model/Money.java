package lotto.model;

import java.util.Objects;

public class Money implements Comparable<Integer> {
    private int money;

    private Money(int money) {
        validateNegative(money);
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public static Money of(String money) {
        try {
            return new Money(Integer.parseInt(money));
        } catch (NumberFormatException ime) {
            throw new IllegalArgumentException("Integer 타입 이외에 입력 받을 수 없습니다.");
        }
    }

    private void validateNegative(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수가 될 수 없습니다.");
        }
    }

    public int divide(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return this.money / divisor;
    }

    @Override
    public int compareTo(Integer money) {
        return this.money - money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
