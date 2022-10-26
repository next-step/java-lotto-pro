package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String REGEX_SEPARATOR = "[,:]";
    public static final String REGEX_CUSTOM_SEPARATOR = "//(.)\n(.*)";
    public static final String ERROR_NEGATIVE_NUMBER = "음수는 포함될 수 없습니다.";

    public static int splitAndSum(String text) {
        if (validateBlank(text)) {
            return 0;
        }
        return Arrays.stream(splitText(text))
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(String number){
        int parseInt = Integer.parseInt(number);
        validateNegativeNumber(parseInt);
        return parseInt;
    }

    private static void validateNegativeNumber(int value) {
        if (value < 0) {
            throw new RuntimeException(ERROR_NEGATIVE_NUMBER);
        }
    }

    private static String[] splitText(String text) {
        Matcher matcher = Pattern.compile(REGEX_CUSTOM_SEPARATOR).matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(REGEX_SEPARATOR);
    }

    private static boolean validateBlank(String text) {
        return isNull(text) || isEmpty(text);
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }

}
