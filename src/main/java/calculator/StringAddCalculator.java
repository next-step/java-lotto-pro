package calculator;

public class StringAddCalculator {
    private static final int MIN_VALUE = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return MIN_VALUE;
        }

        return MIN_VALUE;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
