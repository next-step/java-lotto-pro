package calculator;

import java.util.Objects;

public class Number {
    private static final String ERROR_WRONG_NUMBER_FORMAT = "입력한 숫자를 확인해 주세요.";
    private static final String ERROR_NEGATIVE_NUMBER = "입력된 숫자가 0 미만입니다.";
    private final int number;

    public Number(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    private void validateNumber(String number) {
        int validateNumber = validateInteger(number);
        validateNotPositiveNumber(validateNumber);
    }

    private void validateNotPositiveNumber(int validateNumber) {
        if (validateNumber < 0) {
            throw new NegativeNumberException(ERROR_NEGATIVE_NUMBER);
        }
    }

    private int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_WRONG_NUMBER_FORMAT);
        }
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

    public int getNumber() {
        return number;
    }
}
