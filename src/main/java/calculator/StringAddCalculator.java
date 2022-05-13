package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int MIN_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN_MATCHER = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return MIN_VALUE;
        }

        Numbers numbers = new Numbers(splitValue(input));
        return numbers.sumNumbers();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitValue(String input) {
        Matcher matcher = CUSTOM_PATTERN_MATCHER.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }
}
