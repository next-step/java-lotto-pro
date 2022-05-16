package calculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class Number {
    private final int value;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    public static Number ZERO = new Number(0);

    private Number(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다");
        }
        this.value = value;
    }

    public static Number from(int value) {
        return new Number(value);
    }

    public static Number from(String string) {
        if (!isNumber(string)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다");
        }
        return new Number(Integer.parseInt(string));
    }

    private static boolean isNumber(String string) {
        return NUMBER_PATTERN.matcher(string)
                .matches();
    }

    public Number add(Number other) {
        return new Number(value + other.value);
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
}
