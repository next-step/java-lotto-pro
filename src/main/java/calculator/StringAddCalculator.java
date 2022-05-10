package calculator;

import java.util.Objects;

public class StringAddCalculator {

    private static final int ZERO = 0;

    public static int splitAndSum(final String expression) {
        if (isNullOrEmpty(expression)) {
            return ZERO;
        }

        return ZERO;
    }

    private static boolean isNullOrEmpty(final String expression) {
        return Objects.isNull(expression) || expression.isEmpty();
    }
}
