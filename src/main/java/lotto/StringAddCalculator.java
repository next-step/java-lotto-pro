package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String NULL_VALUE = null;
    private static final String EMPTY_VALUE = "";
    private static final String PIPE_VALUE = "|";
    private static final int DIRECT_RETURN_VALUE = 1;
    private static final String[] SPLIT_DELIMITER_LIST_VALUE = {",", ":"};
    private static final String CUSTOM_SPLIT_DELIMITER_REGEX_VALUE = "//(.)\n(.*)";

    private static final String ERROR_NOT_ALLOW_VALUE_MESSAGE = "[ERROR] 허용하지 않은 값 입니다.";

    public static int sumValue(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        if (isDirectReturn(text)) {
            return stringToIntValue(text);
        }

        return splitSumValue(text);
    }

    public static int splitSumValue(String text) {
        return Arrays.asList(splitText(text)).stream()
                .mapToInt(StringAddCalculator::stringToIntValue)
                .sum();
    }

    public static boolean isNullOrEmpty(String text) {
        return Objects.equals(text, NULL_VALUE) || text.equals(EMPTY_VALUE);
    }

    public static boolean isDirectReturn(String text) {
        return text.length() == DIRECT_RETURN_VALUE;
    }

    public static int stringToIntValue(String text) {
        int number = Integer.parseInt(text);
        checkThrowNumber(number);
        return number;
    }

    private static void checkThrowNumber(int number) {
        if (isNegative(number))
            throw new IllegalArgumentException(ERROR_NOT_ALLOW_VALUE_MESSAGE);
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile(CUSTOM_SPLIT_DELIMITER_REGEX_VALUE).matcher(text);

        if (!m.find())
            return text.split(stringListToString(PIPE_VALUE, Arrays.asList(SPLIT_DELIMITER_LIST_VALUE)));

        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

    private static String stringListToString(String division, List<String> stringList) {
        return String.join(division, stringList);
    }
}
