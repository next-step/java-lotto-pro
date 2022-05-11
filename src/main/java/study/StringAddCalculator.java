package study;

import java.util.List;

public class StringAddCalculator {
    private static final int DEFAULT_NUMBER = 0;

    public static int splitAndSum(String str) {
        if (isNullOrEmpty(str)) {
            return DEFAULT_NUMBER;
        }

        List<Integer> numbers = MatcherUtils.extractNumber(str);
        return sum(numbers);
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(i -> i)
                .sum();
    }
}
