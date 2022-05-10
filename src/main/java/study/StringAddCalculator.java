package study;

public class StringAddCalculator {
    static int splitAndSum(String input) {
        if (isNullOrEmptyInput(input)) {
            return 0;
        }
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        throw new RuntimeException();
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\p{Digit}");
    }

}
