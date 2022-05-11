package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int MIN_NUMBER = 0;
    private static final String REGEX_DELIMITER = "|";
    private static final List<String> STANDARD_DELIMISTERS = Arrays.asList(",", ":");
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String expression) {
        if (isNullOrEmpty(expression)) {
            return MIN_NUMBER;
        }

        List<String> stringNumbers = split(expression);

        return sumPositiveNumbers(stringNumbers);
    }

    private static boolean isNullOrEmpty(final String expression) {
        return Objects.isNull(expression) || expression.isEmpty();
    }

    private static List<String> split(final String expression) {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.asList(m.group(2).split(customDelimiter));
        }

        String regex = makeStandardDelimiterRegex();
        return Arrays.asList(expression.split(regex));
    }

    private static int sumPositiveNumbers(final List<String> stringNumbers) {
        return stringNumbers.stream()
                .mapToInt(Integer::parseInt)
                .peek(StringAddCalculator::checkNegativeNumber)
                .sum();
    }

    private static void checkNegativeNumber(final int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다. number=" + number);
        }
    }

    private static String makeStandardDelimiterRegex() {
        return String.join(REGEX_DELIMITER, STANDARD_DELIMISTERS);
    }
}
