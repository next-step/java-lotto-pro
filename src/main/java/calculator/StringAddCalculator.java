package calculator;

public class StringAddCalculator {
    private static final int EMPTY_TEXT_RESULT = 0;

    public static int splitAndSum(String text) {
        if (isNullOrEmptyString(text)) {
            return EMPTY_TEXT_RESULT;
        }

        return new CalculatorManager(text).getSum();
    }

    public static boolean isNullOrEmptyString(String text) {
        return text == null || text.isEmpty();
    }
}
