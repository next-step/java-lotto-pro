package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER_DEFAULT = ",|:";
    private static final String DELIMITER_PIPE = "|";
    private static final String REGEX_CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String inputString) {
        if (isEmpty(inputString)) {
            return 0;
        }
        if (isNumber(inputString)) {
            return Integer.parseInt(inputString);
        }
        String[] numbers = split(inputString);
        return sum(numbers);
    }

    private static boolean isEmpty(String source) {
        return source == null || source.isEmpty();
    }

    private static boolean isNumber(String source) {
        try {
            Integer.parseInt(source);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String[] split(String inputString) {
        Matcher m = Pattern.compile(REGEX_CUSTOM_DELIMITER).matcher(inputString);
        if (m.find()) {
            String customDelimiters = makeCustomDelimiters(m.group(1));
            return m.group(2).split(customDelimiters);
        }
        return inputString.split(DELIMITER_DEFAULT);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String makeCustomDelimiters(String customDelimiter) {
        return String.join(DELIMITER_PIPE, DELIMITER_DEFAULT, customDelimiter);
    }
}