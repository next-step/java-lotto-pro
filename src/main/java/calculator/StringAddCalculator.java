package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static final int DEFAULT_VALUE = 0;
    public static final int MINIMUM = 0;
    public static final String DELIMITER = ",|:";
    public static final String SHOULD_POSITIVE_MESSAGE = "입력값은 양수여야 합니다";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

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
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(DELIMITER);
    }

    private static List<Integer> parse(String[] inputs) {
        try {
            return Arrays.stream(inputs)
                    .map(StringAddCalculator::toPositive)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static int toPositive(String input) {
        int value = Integer.parseInt(input);

        if (value >= MINIMUM) {
            return value;
        }

        throw new IllegalArgumentException(SHOULD_POSITIVE_MESSAGE);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(DEFAULT_VALUE, (a, b) -> a + b);
    }
}
