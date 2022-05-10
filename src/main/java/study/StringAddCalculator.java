package study;

public class StringAddCalculator {
    static int splitAndSum(String input) {
        if (isNullOrEmptyInput(input)) {
            return 0;
        }

        throw new RuntimeException();
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.isEmpty();
    }
}
