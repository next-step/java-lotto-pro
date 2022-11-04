package calculator;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(final String stringNumber) {
        int number = convertNumber(stringNumber);
        validateNegativeNumber(number);
        this.number = number;
    }

    private int convertNumber(String stringNumber) {
        int number = 0;
        try {
            number = Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
        return number;
    }

    private static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
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
