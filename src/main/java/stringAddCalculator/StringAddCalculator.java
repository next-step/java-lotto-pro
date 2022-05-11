package stringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int result = parseStringToInteger(input);
        return result;
    }

    private static int parseStringToInteger(String str) {
        return Integer.parseInt(str);
    }
}
