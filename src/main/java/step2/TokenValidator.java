package step2;

import java.util.Arrays;

public class TokenValidator {
    public static boolean isNumberOnly(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static void validateTokens(String[] tokens) throws RuntimeException {
        long charCount = getCharCount(tokens);
        long negativeCount = getNegativeCount(tokens);

        if (charCount > 0 || negativeCount > 0) {
            throw new RuntimeException("숫자 이외의 값 또는 음수는 지원하지 않습니다.");
        }
    }

    private static long getCharCount(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(token -> !isNumberOnly(token))
                .count();
    }

    private static long getNegativeCount(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .filter(token -> token < 0)
                .count();
    }
}
