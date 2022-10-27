package step2;

import java.util.List;
import java.util.Objects;

public class StringAddCalculator {

    private static final int ZERO = 0;

    public static int splitAndSum(final String input) {
        if(isNullOrEmpty(input)) {
            return SplitNumber.ZERO;
        }
        SplitNumbers splitNumbers = Splitter.split(input);

        return splitNumbers.sum();
    }

    private static boolean isNullOrEmpty(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
