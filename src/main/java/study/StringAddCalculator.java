package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATORS = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(final String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }

        final String[] splitText = split(text);
        if (splitText.length > 1) {
            return sum(splitText);
        }

        final int number = Integer.parseInt(text);
        return number;
    }

    private static String[] split(final String text) {
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_SEPARATORS);
    }

    private static int sum(final String[] splitText) {
        int sum = 0;
        for (final String text : splitText) {
            sum += Integer.parseInt(text);
        }
        return sum;
    }

    private static boolean isEmptyOrNull(final String text) {
        return text == null || text.isEmpty();
    }
}
