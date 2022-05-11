package calculator;

import calculator.util.SplitUtils;
import calculator.util.StringUtils;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringAddCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("/(.)\n(.*)");
    private static final int PATTERN_TEXT_INDEX = 2;
    private static final int PATTERN_SEPARATOR_INDEX = 1;
    private static final int ZERO = 0;

    private StringAddCalculator() {

    }

    public static int splitAndSum(String text) {
        if (StringUtils.isEmptyString(text)) {
            return 0;
        }
        int[] numbers = calculatorNumberArray(text);
        validNegative(numbers);
        return sum(numbers);
    }

    private static int[] calculatorNumberArray(String text) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(text);
        if (matcher.find()) {
            return SplitUtils.splitToInt(matcher.group(PATTERN_TEXT_INDEX),
                    matcher.group(PATTERN_SEPARATOR_INDEX));
        }
        return SplitUtils.splitToInt(text, DEFAULT_SEPARATOR);
    }

    private static void validNegative(int[] numbers) {
        if (isNegativeContain(numbers)) {
            throw new RuntimeException("문자열 계산기에는 음수를 전달할 수 없습니다.");
        }
    }

    private static boolean isNegativeContain(int[] validSource) {
        return Arrays.stream(validSource)
                .anyMatch((value -> value < ZERO));
    }

    private static int sum(int[] sumSource) {
        return Arrays.stream(sumSource).sum();
    }

}
