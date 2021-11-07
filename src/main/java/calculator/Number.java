package calculator;

import java.util.Objects;

public class Number {
    private static final String NEGATIVE_ERROR_MESSAGE = "양수를 입력해야 합니다";
    private static final String ZERO = "0";

    private final int number;

    public Number(String numberString) {
        if (isNullOrEmpty(numberString)) {
            numberString = ZERO;
        }

        int numberParsed = Integer.parseInt(numberString);
        if (isNegative(numberParsed)) {
            throw new RuntimeException(NEGATIVE_ERROR_MESSAGE);
        }

        this.number = numberParsed;
    }

    private boolean isNegative(int numberParsed) {
        return numberParsed < 0;
    }

    private boolean isNullOrEmpty(String numberString) {
        return numberString == null || numberString.isEmpty();
    }

    public int getNumber() {
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
}
