package calculator;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return 1;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

}
