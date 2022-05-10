package calculator;

import calculator.util.SplitUtils;
import calculator.util.StringUtils;
import java.util.Arrays;


public class StringAddCalculator {

    private final static String BASIC_SEPERATER = ",|:";

    public static int splitAndSum(String text) {
        if (StringUtils.isEmptyString(text)) {
            return 0;
        }
        return sum(text);
    }

    private static int sum(String text) {
        return Arrays.stream(SplitUtils.splitToInt(text, BASIC_SEPERATER)).sum();
    }

}
