package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final int NUMBER_STRING_GROUP = 2;
    private static final int NUMBER_DELIMITER_GROUP = 1;
    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return ZERO;
        }
        if (isOnceNumber(input)) {
            return Integer.parseInt(input);
        }
        String tokens[] = splitToTokens(input);

        return convertNumberAndSum(tokens);
    }

    private static boolean isNullOrEmpty(String input) {
        if (input == null) {
            return true;
        }
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isOnceNumber(String input) {
        if (input.length() > 1) {
            return false;
        }
        if (input.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }

    private static String[] splitToTokens(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(NUMBER_DELIMITER_GROUP);
            return m.group(NUMBER_STRING_GROUP).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static int convertNumberAndSum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int tempNum = convertNumber(token);
            sum += tempNum;
        }
        return sum;
    }

    private static int convertNumber(String token) {
        if (isStringOrNegativeNumber(token)) {
            throw new RuntimeException();
        }
        return Integer.parseInt(token);
    }
    private static boolean isStringOrNegativeNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            return true;
        }
        if (Integer.parseInt(input) < 0) {
            return true;
        }
        return false;
    }
}
