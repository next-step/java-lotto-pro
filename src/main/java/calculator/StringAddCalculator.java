package calculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        if (!hasDelimiter(input)) {
            return oneNumber(input);
        }

        return -1;
    }

    private static int oneNumber(String input) {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (Exception e) {
            throw new RuntimeException("Input is not a number.");
        }

        return isNegativeNumber(num);
    }

    private static int isNegativeNumber(int num) {
        if (num < 0) {
            throw new RuntimeException("Input is not a positive number.");
        }

        return num;
    }

    public static boolean hasDelimiter(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        return input.contains(",") || input.contains(":") || CUSTOM_DELIMITER.matcher(input).matches();
    }
}
