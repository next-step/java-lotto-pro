package lotto;

import java.util.Objects;

public class Number {

    public static final int MIN_RANGE_NUMBER = 1;
    public static final int MAX_RANGE_NUMBER = 45;

    private final int value;

    public Number(int input) {
        validateRange(input);
        this.value = input;
    }

    public Number(String input) {
        this(Integer.parseInt(input));
    }

    private void validateRange(int input) {
        if (input < MIN_RANGE_NUMBER || input > MAX_RANGE_NUMBER) {
            throw new IllegalArgumentException(String.format("%d부터 %d까지의 숫자만 입력 가능합니다.", MIN_RANGE_NUMBER, MAX_RANGE_NUMBER));
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
