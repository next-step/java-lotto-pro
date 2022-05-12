package calculator;

public class PositiveNumber {
    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수가 입력되어 유효하지 않습니다.";
    private static final String CANNOT_CONVERT_NUMBER_EXCEPTION_MESSAGE = "유효하지 않은 입력값입니다.";
    private final int positiveNumber;

    private PositiveNumber(int parseNumber) {
        this.positiveNumber = parseNumber;
    }

    public static PositiveNumber parseNotNegativeNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validNotNegativeNumber(number);
            return new PositiveNumber(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validNotNegativeNumber(int number) {
        if (isNegativeNumber(number)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    public int getPositiveNumber() {
        return this.positiveNumber;
    }
}
