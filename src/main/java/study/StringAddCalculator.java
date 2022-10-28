package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_SEPARATOR = "[,:]";
    public static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (validateText(text)) {
            return 0;
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

    private static int parseInt(String number){
        int parseInt = Integer.parseInt(number);
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
