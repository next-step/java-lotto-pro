package stringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitInput = splitString(input);
        int result = calculateStringSum(splitInput);
        return result;
    }

    private static String[] splitString(String str) {
        return str.split(",|:");
    }

    private static int calculateStringSum(String[] strs) {
        int result = 0;
        for (String str : strs) {
            result += parseStringToInteger(str);
        }
        return result;
    }

    private static int parseStringToInteger(String str) {
        return Integer.parseInt(str);
    }
}
