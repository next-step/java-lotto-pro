package study.step2;

import study.step2.util.StringUtil;

public class StringAddCalculator {
    private static final int DEFAULT_RETURN_VALUE = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return DEFAULT_RETURN_VALUE;
        }
        return sum(StringUtil.split(text));
    }

    private static int sum(String[] numberStrings) {
        int result = 0;
        for (String numberString : numberStrings) {
            result += StringUtil.parseNonNegativeNumber(numberString);
        }
        return result;
    }
}
