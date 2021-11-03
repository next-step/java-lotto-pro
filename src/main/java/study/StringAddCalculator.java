package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATORS = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_INPUT_GROUP = 2;
    private static final String NOT_POSITIVE_ERROR_MESSAGE_FORMAT = "문자열 계산기는 음수를 입력할 수 없습니다. [%d]";
    private static final int ZERO = 0;

    public static int splitAndSum(final String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }
        final String[] splitText = splitByDelimiter(text);
        return sumBySplitText(splitText);
    }

    private static String[] splitByDelimiter(final String text) {
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            return matcher.group(CUSTOM_INPUT_GROUP).split(customDelimiter);
        }
        return text.split(DEFAULT_SEPARATORS);
    }

    private static int sumBySplitText(final String[] splitText) {
        int sum = 0;
        for (final String text : splitText) {
            sum += parsePositiveNumber(text);
        }
        return sum;
    }

    private static int parsePositiveNumber(final String text) {
        final int number = Integer.parseInt(text);
        if (isNotPositiveNumber(number)) {
            throw new RuntimeException(String.format(NOT_POSITIVE_ERROR_MESSAGE_FORMAT, number));
        }
        return number;
    }

    private static boolean isNotPositiveNumber(final int number) {
        return number < ZERO;
    }

    private static boolean isEmptyOrNull(final String text) {
        return text == null || text.isEmpty();
    }
}
