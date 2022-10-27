package step2;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        if(TokenValidator.isNumberOnly(text)) {
            return Integer.parseInt(text);
        }
        String[] tokens = TokenParser.split(text);
        TokenValidator.validateTokens(tokens);
        return getTokensSum(tokens);
    }

    private static int getTokensSum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
