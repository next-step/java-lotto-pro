package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if ("".equals(input) || input == null) {
            return 0;
        }
        String[] split = StringSplitter.split(input);
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
