package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static final String INVALID_INPUT_ERR_MSG = "유효하지 않은 입력값입니다.";
    static final String INVALID_CUSTOM_PATTERN_ERR_MSG = "//와 \\n 문자 사이의 커스텀 구분자와 실제 구분자로 쓰인 값이 다릅니다.";

    private static final int DEFAULT_RETURN_VALUE = 0;
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final Pattern DEFAULT_PATTERN = Pattern.compile("\\d+(" + DEFAULT_DELIMITERS + "\\d+)*");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(\\d+(.\\d+)*)");
    private static final int CUSTOM_PATTERN_DELIMITER_IDX = 1;
    private static final int CUSTOM_PATTERN_VALUE_IDX = 2;

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String input) {
        validate(input);

        if (input == null || input.isEmpty()) {
            return DEFAULT_RETURN_VALUE;
        }
        String[] tokens = split(input);

        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }

    private static void validate(final String input) {
        if (input == null || input.isEmpty()) {
            return;
        }
        if (isDefaultPattern(input)) {
            return;
        }
        if (isValidCustomPattern(input)) {
            return;
        }
        throw new RuntimeException(INVALID_INPUT_ERR_MSG);
    }

    private static boolean isDefaultPattern(final String input) {
        Matcher matcher = DEFAULT_PATTERN.matcher(input);
        return matcher.matches();
    }

    private static boolean isValidCustomPattern(final String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        boolean result = matcher.matches();
        if (result) {
            String customDelimiter = matcher.group(CUSTOM_PATTERN_DELIMITER_IDX);
            String value = matcher.group(CUSTOM_PATTERN_VALUE_IDX);

            validateCustomPattern(value, customDelimiter);
        }
        return result;
    }

    private static void validateCustomPattern(final String value, final String customDelimiter) {
        Pattern validPattern = Pattern.compile("\\d+(" + customDelimiter + "\\d+)*");

        if (!validPattern.matcher(value).matches()) {
            throw new RuntimeException(INVALID_CUSTOM_PATTERN_ERR_MSG);
        }
    }

    private static String[] split(final String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        if (matcher.matches()) {
            String customDelimiter = matcher.group(CUSTOM_PATTERN_DELIMITER_IDX);
            return matcher.group(CUSTOM_PATTERN_VALUE_IDX).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITERS);
    }
}
