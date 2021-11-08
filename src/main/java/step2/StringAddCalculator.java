package step2;

import java.util.Objects;

public final class StringAddCalculator {

    private static final int ZERO = 0;
    private static final int SINGLE_DIGIT_LENGTH = 1;

    private static final String SEPARATOR = "[,:]";

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String text) {
        if (isNull(text)) {
            return ZERO;
        }

        if (isEmpty(text)) {
            return ZERO;
        }

        if (hasSingleDigit(text)) {
            return parseInt(text);
        }

        return sum(split(text));
    }

    private static boolean isNull(final String text) {
        return Objects.isNull(text);
    }

    private static boolean isEmpty(final String text) {
        return text.isEmpty();
    }

    private static boolean hasSingleDigit(final String text) {
        return text.length() == SINGLE_DIGIT_LENGTH;
    }

    private static int parseInt(final String text) {
        return Integer.parseInt(text);
    }

    public static String[] split(final String text) {
        return text.split(SEPARATOR);
    }

    public static int sum(final String[] splitText) {
        int sum = 0;

        for (String text : splitText) {
            sum += parseInt(text);
        }

        return sum;
    }
}
