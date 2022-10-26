package step2;

import java.util.List;
import java.util.Objects;

public class StringAddCalculator {

    private static final int ZERO = 0;

    public static int splitAndSum(final String input) {
        if(isNullOrEmpty(input)) {
            return ZERO;
        }
        return sum(new SplitNumbers(Calculation.split(input)).getSplitNumbers());
    }

    private static int sum(final List<Integer> splitNumbers) {
        return splitNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isNullOrEmpty(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
