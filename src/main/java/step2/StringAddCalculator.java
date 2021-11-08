package step2;

import java.util.Objects;

public final class StringAddCalculator {

    private StringAddCalculator() {
    }

    private static final int ZERO = 0;
    private static final int SINGLE_DIGIT_LENGTH = 1;

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

        return 2;
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
}
