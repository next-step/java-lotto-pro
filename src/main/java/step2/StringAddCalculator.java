package step2;

import java.util.List;

public class StringAddCalculator {

    private static final int ZERO = 0;

    private static Calculation calculation;

    public static int splitAndSum(final String input) {
        if (calculation.isNullOrEmpty(input)) {
            return ZERO;
        }
        calculation = new Calculation(input);

        return sum(calculation.getSplitNumbers());
    }

    private static int sum(final List<String> splitNumbers) {
        return splitNumbers.stream()
            .mapToInt(Integer::parseInt)
            .peek(splitNumber -> checkNegative(splitNumber))
            .sum();
    }

    private static void checkNegative(final int splitNumber) {
        if (splitNumber < ZERO) {
            throw new IllegalArgumentException("덧셈에 음수는 허용되지 않습니다.");
        }
    }
}
