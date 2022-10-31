package calculator;

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
}
