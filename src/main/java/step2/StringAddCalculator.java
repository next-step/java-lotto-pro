package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,:]";

    public static int splitAndSum(String text) {
        String[] tokens = split(text);
        return getTokensSum(tokens);
    }

    private static String[] split(String text) {
        String[] tokens = null;
        if(text.contains(",") || text.contains(":")) {
            tokens = splitWithDefaultSeparator(text);
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customSeparator = m.group(1);
            tokens = splitWithCustomSeparator(m.group(2), customSeparator);
        }
        return tokens;
    }

    private static String[] splitWithDefaultSeparator(String text) {
        return text.split(DEFAULT_SEPARATOR);
    }

    private static String[] splitWithCustomSeparator(String text, String separator) {
        return text.split(separator);
    }

    private static int getTokensSum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
