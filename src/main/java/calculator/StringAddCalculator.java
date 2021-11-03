package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ignored) {
        }
        return Arrays.stream(text.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
