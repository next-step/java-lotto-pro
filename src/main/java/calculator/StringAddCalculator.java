package calculator;

public class StringAddCalculator {
    public static final int DEFAULT = 0;

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return DEFAULT;
        }

        return 1;
    }

    private static boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        return false;
    }
}
