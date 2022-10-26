package calculator;

public class Number {
    private static final int ZERO = 0;
    private static final String ERROR_MESSAGE_NEGATIVE = "음수는 입력 불가능 합니다.";
    private static final String ERROR_MESSAGE_ONLY_NUMBER = "숫자 이외의 값은 입력 불가능합니다.";

    private int number;

    public Number(String text) {
        try {
            int parseNumber = Integer.parseInt(text);
            validNegative(parseNumber);
            this.number = parseNumber;
        } catch (NumberFormatException e) {
            throw new RuntimeException(ERROR_MESSAGE_ONLY_NUMBER);
        }
    }

    private static void validNegative(int number) {
        if (number < ZERO) {
            throw new RuntimeException(ERROR_MESSAGE_NEGATIVE);
        }
    }
}
