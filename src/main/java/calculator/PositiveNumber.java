package calculator;

public class PositiveNumber {
    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수가 입력되었습니다. 0 이상 값을 입력해주세요.";
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자 이외의 값이 입력되었습니다. 숫자를 입력해주세요.";
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
            throw new RuntimeException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validNotNegativeNumber(int number) {
        if (isNegativeNumber(number)) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    public int getPositiveNumber() {
        return this.positiveNumber;
    }
}
