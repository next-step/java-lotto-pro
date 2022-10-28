package study;

import java.util.Arrays;

public class StringAddCalculator {

    public static final String DEFAULT_SEPARATOR = "[,:]";

    public static int splitAndSum(String text) {
        if (validateText(text)) {
            return 0;
        }
        return sum(text);
    }

    private static String[] splitText(String text) {
        return text.split(DEFAULT_SEPARATOR);
    }

    private static int sum(String text){
        return Arrays.stream(splitText(text))
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
