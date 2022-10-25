package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static final int DEFAULT_RETURN = 0;

    private StringAddCalculator() {
        throw new IllegalStateException("Utility Class");
    }

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return DEFAULT_RETURN;
        }

        String[] splitNumbers = StringSplitter.split(input);
        return Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).sum();
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

}
