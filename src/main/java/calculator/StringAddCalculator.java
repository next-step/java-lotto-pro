package calculator;

import utlis.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int ZERO_NUMBER = 0;
    private static final String DEFAULT_SEPARATORS = ",|:";
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_INPUT_GROUP = 2;


    public static int splitAndSum(String text) {
        if (StringUtils.isNullOrEmpty(text)) {
            return ZERO_NUMBER;
        }
        String[] splitText = splitText(text);
        return sumSplitText(splitText);
    }

    private static String[] splitText(String text) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(text);
        String delimiter = DEFAULT_SEPARATORS;
        if (matcher.find()) {
            delimiter = delimiter + "|" + matcher.group(CUSTOM_DELIMITER_GROUP);
            text = matcher.group(CUSTOM_INPUT_GROUP);
        }
        return text.split(delimiter);
    }

    private static int sumSplitText(String[] splitText) {
        return Arrays.stream(splitText)
                .mapToInt(item -> convertPositiveNumber(item.toString()))
                .sum();
    }

    private static int convertPositiveNumber(String text) {
        if (!text.matches(POSITIVE_NUMBER_REGEX)) {
            throw new RuntimeException(String.format("문자열 계산기에 음수는 올 수 없습니다.", text));
        }
        return Integer.parseInt(text);
    }

}
