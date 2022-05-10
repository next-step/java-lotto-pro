package stringcalculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (isNull(input) || input.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(input);
    }

    private static boolean isNull(String input) {
        return input == null;
    }
}
