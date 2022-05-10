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
        if (isPositiveNumber(inputString)) {
            return Integer.parseInt(inputString);
        }
        String[] numbers = split(inputString);
        validatePositiveNumbers(numbers);
        return sum(numbers);
    }


    private static boolean isEmpty(String source) {
        return source == null || source.isEmpty();
    }

    private static boolean isPositiveNumber(String source) {
        try {
            return Integer.parseInt(source) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void validatePositiveNumbers(String[] source) {
        boolean isPositiveNumbers = Arrays.stream(source)
                                        .allMatch(StringAddCalculator::isPositiveNumber);
        if (!isPositiveNumbers) {
            throw new RuntimeException(ErrorMessage.ERROR_NOT_POSITIVE_NUMBER.getMessage());
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