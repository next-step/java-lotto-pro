package study.step2;

import java.util.Objects;

public class StringAddCalculator {
    private static final int ZERO = 0;

    public static int splitAndSum(String numberString) {
        return isNullOrEmptyString(numberString) ? ZERO : Integer.parseInt(numberString);
    }

    private static boolean isNullOrEmptyString(String numbers) {
        return Objects.isNull(numbers) || numbers.isEmpty();
    }
}
