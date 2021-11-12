package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    private final int number;

    public Number(final int number) {
        validateRange(number);
        this.number = number;
    }

    public Number(final String number) {
        this(parseInt(number));
    }

    private static int parseInt(final String number) {
        int value;
        try {
            value = Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("로또 번호를 올바르게 입력해주세요.");
        }
        return value;
    }

    private static void validateRange(final int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(
                "로또 숫자는 " + LOWER_BOUND + "보다 크거나 " + UPPER_BOUND + "보다 작아야합니다."
            );
        }
    }

    public int getValue() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(final Number o) {
        return Integer.compare(number, o.number);
    }
}
