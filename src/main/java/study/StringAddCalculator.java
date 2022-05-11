package study;

import java.util.Arrays;

public class StringAddCalculator {
    private static final int DEFAULT_NUMBER = 0;

    public static int splitAndSum(String str) {
        if (isNullOrEmpty(str)) {
            return DEFAULT_NUMBER;
        }

        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .sum();
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
