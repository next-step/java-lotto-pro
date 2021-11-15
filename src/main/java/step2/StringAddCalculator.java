package step2;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.NumberUtils;

public final class StringAddCalculator {

    private static final int ZERO = 0;
    private static final int SINGLE_DIGIT_LENGTH = 1;

    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    private static final String[] EMPTY_TEXT = {};

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String text) {
        if (isNull(text)) {
            return ZERO;
        }

        if (isEmpty(text)) {
            return ZERO;
        }

        if (hasSingleNumber(text)) {
            return parseInt(text);
        }

        if (isDelimiterContainCommaAndColon(text)) {
            return sum(split(text));
        }

        return sum(customSplit(text));
    }

    private static boolean isNull(final String text) {
        return Objects.isNull(text);
    }

    private static boolean isEmpty(final String text) {
        return text.isEmpty();
    }

    private static boolean hasSingleNumber(final String text) {
        return text.length() == SINGLE_DIGIT_LENGTH;
    }

    private static int parseInt(final String text) {
        return NumberUtils.parseInt(text);
    }

    private static boolean isDelimiterContainCommaAndColon(final String text) {
        return text.contains(",") || text.contains(":");
    }

    private static String[] split(final String text) {
        return text.split(DELIMITER);
    }

    private static String[] customSplit(final String text) {
        final Matcher matcher = CUSTOM_DELIMITER.matcher(text);

        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return EMPTY_TEXT;
    }

    private static boolean isNegative(final int number) {
        return number < ZERO;
    }

    private static void validateNegative(final int number) {
        if (isNegative(number)) {
            throw new RuntimeException("not allowed negative numbers.");
        }
    }

    private static int sum(final String[] splitText) {
        int sum = 0;

        for (String text : splitText) {
            final int number = parseInt(text);
            validateNegative(number);

            sum += number;
        }

        return sum;
    }
}
