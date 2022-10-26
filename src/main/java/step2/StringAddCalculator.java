package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,:]";

    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        if(isNumberOnly(text)) {
            return Integer.parseInt(text);
        }
        String[] tokens = split(text);
        checkTokenValidation(tokens);
        return getTokensSum(tokens);
    }

    private static boolean isNumberOnly(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
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

    private static void checkTokenValidation(String[] tokens) throws RuntimeException {
        long charCount = Arrays.stream(tokens)
                .filter(token -> !isNumberOnly(token))
                .count();
        long negativeCount = Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .filter(token -> token < 0)
                .count();
        if(charCount > 0 || negativeCount > 0) {
            throw new RuntimeException("숫자 이외의 값 또는 음수는 지원하지 않습니다.");
        }
    }

    private static int getTokensSum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
