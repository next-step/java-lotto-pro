package step2;

import java.util.Objects;

public final class StringAddCalculator {

    private StringAddCalculator() {
    }

    private static final int ZERO = 0;

    public static int splitAndSum(final String text) {
        if (isNull(text)) {
            return ZERO;
        }

        if (isEmpty(text)) {
            return ZERO;
        }

        return 1;
    }

    private static boolean isNull(final String text) {
        return Objects.isNull(text);
    }

    private static boolean isEmpty(final String text) {
        return text.isEmpty();
    }
}
