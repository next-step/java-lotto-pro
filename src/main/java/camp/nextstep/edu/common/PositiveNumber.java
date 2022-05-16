package camp.nextstep.edu.common;

import java.util.Objects;

public class PositiveNumber {
    private static final String NUMBER_CHECK_REGEX = "-?\\d+";
    private static final long MIN_VALUE = 0L;

    private final long value;

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

    public PositiveNumber add(PositiveNumber target) {
        if (target.getValue() == 0) {
            return this;
        }

        return new PositiveNumber(this.value + target.value);
    }

    public PositiveNumber subtract(PositiveNumber target) {
        if (target.getValue() == 0) {
            return this;
        }
        checkSubtractable(target);

        return new PositiveNumber(this.value - target.value);
    }

    public PositiveNumber multiply(PositiveNumber target) {
        return new PositiveNumber(this.value * target.value);
    }

    public PositiveNumber divideAndGetShare(PositiveNumber target) {
        checkPossibleDevice(target);
        return new PositiveNumber(this.value / target.value);
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

    private void checkSubtractable(PositiveNumber target) {
        if (this.value - target.value < MIN_VALUE) {
            throw new RuntimeException(this.value + "보다 더 큰 값을 뺄 수 없습니다.");
        }
    }

    private void checkPossibleDevice(PositiveNumber target) {
        if (target.value == 0) {
            throw new RuntimeException("0 으로 나눌 수 없습니다.");
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
