package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;
    private static final int MINIMUM = 0;
    private static final String SHOULD_POSITIVE_MESSAGE = "입력값은 양수여야 합니다";
    private static final Pattern STANDARD_PATTERN = Pattern.compile(",|:");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_INPUT_INDEX = 2;

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return DEFAULT_VALUE;
        }

        return sum(parse(split(input)));
    }

    private static boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        return false;
    }

    private static String[] split(String input) {
        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            return m.group(CUSTOM_INPUT_INDEX).split(customDelimiter);
        }

        return STANDARD_PATTERN.split(input);
    }

    private static List<Integer> parse(String[] inputs) {
        return Arrays.stream(inputs)
                .map(StringAddCalculator::toPositive)
                .collect(Collectors.toList());
    }

    private static int toPositive(String input) {
        int value = toInt(input);

        if (value < MINIMUM) {
            throw new RuntimeException(SHOULD_POSITIVE_MESSAGE);
        }

        return value;
    }

    private static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(SHOULD_POSITIVE_MESSAGE, e);
        }
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
