package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    private static final String DEFAULT_PATTERN = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DEFAULT_SUM = 0;
    private static final int NUMBERS_INDEX = 2;
    private static final int DELIMITER_INDEX = 1;
    private static final int ZERO = 0;

    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return DEFAULT_SUM;
        }

        String[] numbers = split(text);

        return sum(numbers);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.length() == ZERO;
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(NUMBERS_INDEX).split(matcher.group(DELIMITER_INDEX));
        }

        return text.split(DEFAULT_PATTERN);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(StringAddCalculator::convertPositiveNumber)
                .sum();
    }

    private static int convertPositiveNumber(String value) {
        int number = fromString(value);

        if (number < ZERO) {
            throw new RuntimeException("음수가 될순없습니다.");
        }

        return number;
    }

    private static int fromString(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 존재합니다.");
        }
    }
}
