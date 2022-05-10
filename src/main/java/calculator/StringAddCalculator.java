package calculator;

import calculator.util.SplitUtils;
import calculator.util.StringUtils;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringAddCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "/(.)\n(.*)";
    private static final int ZERO = 0;

    private StringAddCalculator() {

    }

    public static int splitAndSum(String text) {
        if (StringUtils.isEmptyString(text)) {
            return 0;
        }

        int[] numberArray = calculatorNumberArray(text);
        validNegativeArray(numberArray);
        return sum(numberArray);
    }

    private static void validNegativeArray(int[] array) {
        if (Arrays.stream(array)
                .filter((v) -> v < ZERO)
                .findFirst().isPresent()) {
            throw new RuntimeException("문자열 계산기에는 음수를 전달할 수 없습니다.");
        }
    }

    private static int[] calculatorNumberArray(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (matcher.find()) {
            return SplitUtils.splitToInt(matcher.group(2), matcher.group(1));
        }
        return SplitUtils.splitToInt(text, DEFAULT_SEPARATOR);
    }

    private static int sum(int[] array) {
        return Arrays.stream(array).sum();
    }

}
