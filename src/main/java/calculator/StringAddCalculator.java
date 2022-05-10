package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int sum = 0;
        if (isNullOrEmpty(input)) {
            return sum;
        }
        sum = Integer.parseInt(input);
        return sum;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
