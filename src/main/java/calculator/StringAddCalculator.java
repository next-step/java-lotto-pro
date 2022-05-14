package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.StringUtil;

public class StringAddCalculator {

    private static final int GROUP_INDEX_CUSTOM_DELIMITER = 1;
    private static final int GROUP_INDEX_VALUE_TEXT = 2;

    private static final Pattern PATTERN_CUSTOM_DELIMITER_TEXT = Pattern.compile("//(.)\n(.*)");
    private static final String ERROR_MESSAGE_NEGATIVE_NUMBER = "[ERROR] Negative values not allowed.";

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String text) {

        if (StringUtil.isEmpty(text)) {
            return 0;
        }

        return splitAndSumFromNumbersString(text);
    }

    private static int splitAndSumFromNumbersString(final String numbersString) {
        List<Integer> numberList = extractNumberList(numbersString);

        return sumNumberList(numberList);
    }

    private static List<Integer> extractNumberList(final String numbersString) {
        Matcher matcher = PATTERN_CUSTOM_DELIMITER_TEXT.matcher(numbersString);
        if (matcher.find()) {
            String customDelimiter = matcher.group(GROUP_INDEX_CUSTOM_DELIMITER);
            String valueText = matcher.group(GROUP_INDEX_VALUE_TEXT);

            return StringUtil.splitNumbersString(valueText, customDelimiter);
        }

        return StringUtil.splitNumbersString(numbersString);
    }

    private static int sumNumberList(final List<Integer> numberList) {
        int result = 0;

        for (Integer number : numberList) {
            checkNegativeNumber(number);
            result += number;
        }

        return result;
    }

    private static void checkNegativeNumber(final Integer number) {
        if (number < 0) {
            System.out.println(ERROR_MESSAGE_NEGATIVE_NUMBER);
            throw new IllegalArgumentException(ERROR_MESSAGE_NEGATIVE_NUMBER);
        }
    }
}
