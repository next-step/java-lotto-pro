package util;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return sum(text);
    }

    private static int sum(String text) {
        int result = 0;
        for (String number : text.split(",")) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
