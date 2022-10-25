package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        String[] splitValue = new String[0];
        if (value == null || value.isEmpty()) {
            return 0;
        }
        if (isSingleNumber(value)) {
            return Integer.parseInt(value);
        }
        if (value.contains(",") || value.contains(":")) {
            splitValue = splitByCommaAndColon(value);
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find()) {
            splitValue = splitByCustomPattern(m, value);
        }
        checkNegativeNumber(splitValue);
        return sumStringArray(splitValue);
    }

    private static boolean isSingleNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static String[] splitByCommaAndColon(String value) {
        return value.split(",|:");
    }

    private static String[] splitByCustomPattern(Matcher m, String value) {
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

    private static int sumStringArray(String[] splitValue) {
        return Arrays.stream(splitValue).mapToInt(Integer::parseInt).sum();
    }

    private static void checkNegativeNumber(String[] splitValue) {
        long count = Arrays.stream(splitValue)
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 0)
                .count();
        if (count > 0) {
            throw new RuntimeException("negative number included");
        }
    }

}
