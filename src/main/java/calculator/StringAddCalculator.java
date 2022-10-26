package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String REGEX_COMMA_OR_COLON_SEPARATOR = ",|:";
    private static final String REGEX_CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(REGEX_CUSTOM_SEPARATOR);

    private StringAddCalculator() {
    }

    public static int calculate(String input) {
        if (isNull(input) || input.isEmpty()) {
            return ZERO;
        }

        String[] split = splitText(input);
        validNumbers(split);
        return sum(split);
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static String[] splitText(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            return matcher.group(2).split(customSeparator);
        }
        return input.split(REGEX_COMMA_OR_COLON_SEPARATOR);
    }

    private static void validNumbers(String[] numbers) {
        for (String number : numbers) {
            new Number(number);
        }
    }

    private static int sum(String[] split) {
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}