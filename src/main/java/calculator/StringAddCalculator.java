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
        String separator = DEFAULT_SEPARATOR;
        if (matcher.find()) {
            text = matcher.group(PATTERN_TEXT_INDEX);
            separator = matcher.group(PATTERN_SEPARATOR_INDEX);
        }
        return patternNumbers(text, separator);
    }

    private static int[] patternNumbers(String text, String separator) {
        try {
            return SplitUtils.splitToInt(text, separator);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Message.ONLY_NUMBER_TEXT.getMessage());
        }
    }

    private static void validNegative(int[] numbers) {
        if (isNegativeContain(numbers)) {
            throw new RuntimeException(Message.ONLY_POSITIVE_NUMBER_TEXT.getMessage());
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
