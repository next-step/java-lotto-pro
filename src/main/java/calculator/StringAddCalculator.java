package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return customDelimiterAdd(matcher);
        }
        String[] numbers = text.split(DEFAULT_DELIMITER);
        return stringAdd(numbers);
    }

    private static int customDelimiterAdd(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] numbers = matcher.group(2).split(customDelimiter);
        return stringAdd(numbers);
    }

    private static int stringAdd(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parseNumber = parseIntNumber(number);
            isPositiveNumber(parseNumber);
            sum += parseNumber;
        }
        return sum;
    }

    private static int parseIntNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static void isPositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

}
