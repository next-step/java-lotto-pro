package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern numberPattern = Pattern.compile("\\d+");
    private static final Pattern customPattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return sum(text);
    }

    private static int sum(String text) {
        Matcher matcher = customPattern.matcher(text);
        if (matcher.find()) {
            return getSumByCustomAndDefaultSplit(matcher);
        }
        return getSumByDefaultSplit(text);
    }

    private static int getSumByCustomAndDefaultSplit(Matcher matcher) {
        int result = 0;
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);
        for (String token : tokens) {
            result += getSumByDefaultSplit(token);
        }
        return result;
    }

    private static int getSumByDefaultSplit(String text) {
        int result = 0;
        for (String number : text.split("[,:]")) {
            validateNumberFormat(number);
            result += getNumber(number);
        }
        return result;
    }

    private static int getNumber(String number) {
        int value = Integer.parseInt(number);
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    private static void validateNumberFormat(String number) {
        if (!numberPattern.matcher(number).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
