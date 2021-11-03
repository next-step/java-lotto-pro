package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return Arrays.stream(text.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
