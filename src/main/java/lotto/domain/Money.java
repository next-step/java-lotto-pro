package lotto.domain;

import java.util.Objects;

public class Money {

    private static final int PERCENTAGE = 100;

    private final int won;

    private Money(String won) {
        this(Integer.parseInt(won));
    }

    private Money(int money) {
        this.won = money;
    }

    public static Money of(String money) {
        try {
            return new Money(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 금액을 입력해주세요.");
        }
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public static Money zero() {
        return new Money(0);
    }

    public boolean isLessThan(Money money) {
        return won < money.won;
    }

    public int divide(Money money) {
        return won / money.won;
    }

    public double divideDecimal(Money money) {
        double late = won / (double) money.won;
        return makeTwoDecimalPlace(late);
    }

    private double makeTwoDecimalPlace(double late) {
        return Math.floor(late * PERCENTAGE) / (double) PERCENTAGE;
    }

    public Money multiply(int count) {
        return Money.of(won * count);
    }

    public Money plus(Money prizeMoney) {
        return Money.of(this.won + prizeMoney.won);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return won == money.won;
    }

    @Override
    public int hashCode() {
        return Objects.hash(won);
    }

    @Override
    public String toString() {
        return String.valueOf(won);
    }
}
