package step2;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,:]";

    public static int splitAndSum(String text) {
        String[] tokens = splitWithDefaultSeparator(text);
        return getTokensSum(tokens);
    }

    private static String[] splitWithDefaultSeparator(String text) {
        return text.split(DEFAULT_SEPARATOR);
    }

    private static int getTokensSum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
