package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int BRANK_NUMBER = 0;
    private static final int VALIDATE_MINIMUM_NUMBER = 0;
    private static final String DEFAULT_SPLIT_REGEX = ",|:";
    private static final Pattern FIND_CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return BRANK_NUMBER;
        }
        String[] tokens = split(text);
        return sum(tokens);
    }

    private static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    private static String[] split(String text) {
        Matcher matcher = FIND_CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_SPLIT_REGEX);
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(token -> parseInt(token)).sum();
    }

    private static int parseInt(String token) {
        int number = Integer.parseInt(token);
        validateNumber(number);
        return number;
    }

    private static void validateNumber(int number) {
        if (number < VALIDATE_MINIMUM_NUMBER) {
            throw new RuntimeException();
        }
    }

}
