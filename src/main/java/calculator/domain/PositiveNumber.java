package calculator.domain;

import java.util.Objects;

public class PositiveNumber {
    private static final String MSG_NOT_NUMBER = "숫자 이외의 값을 입력으로 받을 수 없습니다.";
    private static final String MSG_NEGATIVE = "음수를 입력으로 받을 수 없습니다";

    private int positiveNumber;

    private PositiveNumber(String numberString) {
        validate(numberString);
        positiveNumber = Integer.parseInt(numberString);
    }

    private PositiveNumber(int number) {
        validatePositive(number);
        positiveNumber = number;
    }

    public static PositiveNumber of(String numberString) {
        return new PositiveNumber(numberString);
    }

    public static PositiveNumber of(int number) {
        return new PositiveNumber(number);
    }

    public PositiveNumber add(PositiveNumber target) {
        return PositiveNumber.of(this.positiveNumber + target.positiveNumber);
    }

    public void validate(String numberString) {
        validateNumber(numberString);
        validatePositive(numberString);
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException(MSG_NOT_NUMBER);
        }
    }

    private static void validatePositive(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(MSG_NEGATIVE);
        }
    }

    private static void validatePositive(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(MSG_NEGATIVE);
        }
    }

    public int toNumber() {
        return this.positiveNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber that = (PositiveNumber) o;
        return positiveNumber == that.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }
}
