package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String REGEX_DELIMITER = "|";
    private static final List<String> STANDARD_DELIMISTERS = Arrays.asList(",", ":");

    public static int splitAndSum(final String expression) {
        if (isNullOrEmpty(expression)) {
            return ZERO;
        }

        List<String> stringNumbers = split(expression);

        return sum(stringNumbers);
    }

    private static boolean isNullOrEmpty(final String expression) {
        return Objects.isNull(expression) || expression.isEmpty();
    }

    private static List<String> split(final String expression) {
        String regex = makeStandardDelimiterRegex();
        return Arrays.asList(expression.split(regex));
    }

    private static int sum(final List<String> stringNumbers) {
        return stringNumbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String makeStandardDelimiterRegex() {
        return String.join(REGEX_DELIMITER, STANDARD_DELIMISTERS);
    }
}
