package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final int EMPTY_RESULT = 0;
    private static final String NEGATIVE_NUMBER_ERROR = "[ERROR] 음수 이거나 숫자 이외의 값은 처리할 수 없습니다.";

    public static int splitAndSum(String text) {
        if (validateText(text)) {
            return EMPTY_RESULT;
        }
        return sum(text);
    }

    private static String[] splitWithCustomText(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return splitText(text);
    }

    private static String[] splitText(String text) {
        return text.split(DEFAULT_SEPARATOR);
    }

    private static int sum(String text){
        return Arrays.stream(splitWithCustomText(text))
            .mapToInt(StringAddCalculator::parseInt)
            .sum();
    }

    private static void validateNegativeNumber(int number){
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
    }

    private static int parseInt(String number){
        int parseInt = Integer.parseInt(number);
        validateNegativeNumber(parseInt);
        return parseInt;
    }

    private static boolean validateText(String text) {
        return isNull(text) || isEmpty(text);
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }
}
