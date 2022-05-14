package calculator;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input))
            return DEFAULT_VALUE;
        return 0;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
