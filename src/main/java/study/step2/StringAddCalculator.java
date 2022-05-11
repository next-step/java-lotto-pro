package study.step2;

import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {
    private static final int ZERO = 0;

    private static final String DELIMITERS = ",";

    public static int splitAndSum(String numberString) {
        if (isNullOrEmptyString(numberString)) {
            return ZERO;
        }

        return Arrays.asList(numberString.split(DELIMITERS)).stream()
                .map(Integer::valueOf)
                .reduce(ZERO, (num1, num2) -> num1 + num2);
    }

    private static boolean isNullOrEmptyString(String numbers) {
        return Objects.isNull(numbers) || numbers.isEmpty();
    }


}
