package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static final String DELIMITER = ",";

    public static int splitAndSum(String str) {
        if (isBlank(str)) {
            return 0;
        }
        return sum(toInts(split(str)));
    }

    private static int sum(int[] values) {
        return Arrays.stream(values).sum();
    }

    private static int[] toInts(String[] values) {
        return Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
    }

    private static String[] split(String str) {
        return str.split(DELIMITER);
    }

    private static boolean isBlank(String str) {
        return str == null || str.isEmpty();
    }
}
