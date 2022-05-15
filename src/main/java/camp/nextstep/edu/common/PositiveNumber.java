package camp.nextstep.edu.common;

import java.util.Objects;

public class PositiveNumber {
    private static final String NUMBER_CHECK_REGEX = "-?\\d+";

    private final long value;

    public PositiveNumber(int value) {
        checkPositiveNumber(value);

        this.value = value;
    }

    public PositiveNumber(long value) {
        checkPositiveNumber(value);
        this.value = value;
    }

    public PositiveNumber(String value, boolean isConvertEmptyOrNullToZero) {
        String convertedValue = convertEmptyOrNullToZero(value, isConvertEmptyOrNullToZero);

        checkValidNumberByString(convertedValue);

        long convertValue = Long.parseLong(convertedValue);
        checkPositiveNumber(convertValue);

        this.value = convertValue;
    }

    public long getValue() {
        return this.value;
    }

    private void checkPositiveNumber(long value) {
        if (value < 0) {
            throw new RuntimeException("양수만 허용됩니다.");
        }
    }

    private void checkValidNumberByString(String value) {
        if (!value.matches(NUMBER_CHECK_REGEX)) {
            throw new RuntimeException("숫자만 허용됩니다.");
        }
    }

    private String convertEmptyOrNullToZero(String value, boolean convertedValue) {
        if (convertedValue && value.isEmpty()) {
            return "0";
        }
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
