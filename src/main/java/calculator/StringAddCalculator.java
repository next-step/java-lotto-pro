package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final int DELIMITER_GROUP = 1;
    private static final int CUSTOM_INPUT_GROUP = 2;

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] split = getSplit(input);
        return sumNumbers(split);
    }

    private static String[] getSplit(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP);
            return matcher.group(CUSTOM_INPUT_GROUP).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private static int sumNumbers(String[] split) {
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }
}
