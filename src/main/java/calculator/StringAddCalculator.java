package calculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        return -1;
    }

    public static boolean hasDelimiter(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        return input.contains(",") || input.contains(":") || CUSTOM_DELIMITER.matcher(input).matches();
    }
}
