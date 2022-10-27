package step2;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        if(isNumberOnly(text)) {
            return Integer.parseInt(text);
        }
        String[] tokens = TokenParser.split(text);
        validateTokens(tokens);
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

    private static void validateTokens(String[] tokens) throws RuntimeException {
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
