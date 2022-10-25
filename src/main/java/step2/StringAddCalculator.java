package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmptyValue(text)) {
            return 0;
        }
        String[] textArray = splitText(text);
        return sumText(textArray);
    }

    private static boolean isNullOrEmptyValue(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitText(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static int sumText(String[] textArray) {
        return Arrays.stream(textArray)
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
