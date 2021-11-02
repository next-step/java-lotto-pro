package study;

import study.utils.StringUtils;

public class StringAddCalculator {

    private StringAddCalculator() {
        throw new UnsupportedOperationException();
    }

    public static int splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        if (StringUtils.isNumber(text)) {
            return Integer.parseInt(text);
        }

        return 0;
    }
}
