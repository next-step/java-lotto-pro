package lotto.model;

import java.util.Objects;

public class Money {
    private static final int MINIMUM = 1000;
    private static final int MAXIMUM = 100000;
    private static final String OUT_OF_RANGE = "범위를 벗어난 금액입니다.";

    private final int money;

    public Money(int input) {
        validate(input);
        money = input;
    }

    public Money(String input) {
        this(readInt(input));
    }

    public int value() {
        return money;
    }

    private static int readInt(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    private static void validate(int input) {
        if (input < MINIMUM || input > MAXIMUM) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
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
