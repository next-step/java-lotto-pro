package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.*)\n(.*)");

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(text);
        String[] numbers;
        if (matcher.find()) {
            numbers = matcher.group(2).split(matcher.group(1));
        } else {
            numbers = text.split(DEFAULT_DELIMITER_REGEX);
        }

        return Arrays.stream(numbers).mapToInt(value -> {
            negativeExceptionValid(value);
            return Integer.parseInt(value);
        }).sum();
    }

    public static String[] stringSplit(String input) {
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);
        if (matcher.find()) {
            return splitDelimiterOfCustom(matcher);
        }

        return splitDelimiterOfDefault(input);
    }

    public static String[] splitDelimiterOfDefault(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    public static String[] splitDelimiterOfCustom(Matcher matcher) {
        return matcher.group(2).split(matcher.group(1));
    }

    private static void negativeExceptionValid(String value) {
        if (Integer.parseInt(value) < 0 || !isNumber(value)) {
            throw new RuntimeException();
        }
    }

    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
