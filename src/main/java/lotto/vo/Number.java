package lotto.vo;

import java.util.Objects;

public class Number {
    private static String NEGATIVE_INTEGER_IS_NOT_ALLOWED = "음의 정수는 허용되지 않습니다.";

    private int number;

    public Number(final int number) {
        if (number < 1) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER_IS_NOT_ALLOWED);
        }
        this.number = number;
    }

    public Number(final String number) throws NumberFormatException {
        this(readInt(number));
    }

    private static int readInt(String input) {
        return Integer.parseInt(input);
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
