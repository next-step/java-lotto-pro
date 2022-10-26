package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int NULL_OR_EMPTY_VALUE = 0;
    private static final String CUSTOM_SPLIT_TEXT = "//(.)\n(.*)";
    private static final String MULTI_SPLIT_TEXT = ":|,";

    public static int splitAndSum(String text) {
        if (isNullOrEmptyValue(text)) {
            return NULL_OR_EMPTY_VALUE;
        }
        List<String> textArray = splitText(text);
        return sumText(textArray);
    }

    private static boolean isNullOrEmptyValue(String text) {
        return text == null || text.isEmpty();
    }

    private static List<String> splitText(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_TEXT).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        return Arrays.asList(text.split(MULTI_SPLIT_TEXT));
    }

    private static int sumText(List<String> textArray) {
        return textArray.stream()
                .mapToInt(StringAddCalculator::convertInteger)
                .sum();
    }

    private static int convertInteger(String text) {
        int number = Integer.parseInt(text);
        if (isNegativeNumber(number)) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

}
