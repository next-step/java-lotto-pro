package study;

import java.util.Arrays;

public class StringAddCalculator {
    private static final int DEFAULT_NUMBER = 0;

    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return DEFAULT_NUMBER;
        }

        return Arrays.stream(str.split(","))
                .map(s -> Integer.parseInt(s))
                .mapToInt(i -> i)
                .sum();
    }
}
