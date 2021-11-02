package step2;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return Arrays.stream(SplitDelimiter.stringSplit(text))
            .mapToInt(SplitNumber::valueOf)
            .sum();
    }
}
