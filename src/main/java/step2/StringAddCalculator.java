package step2;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return Arrays.stream(SplitDelimiter.stringSplit(text))
            .mapToInt(SplitNumber::valueOf)
            .sum();
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
