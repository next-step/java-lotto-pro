package step2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isStringNullOrEmpty(text)) {
            return 0;
        }
        if (isNumber(text)) {
            return Integer.parseInt(text);
        }
        String[] splitNumbers = splitNumber(text);
        return addAllNumbers(splitNumbers);
    }

    private static int addAllNumbers(String[] splitNumbers) {
        return 0;
    }

    private static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isStringNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitNumber(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return splitByCommaAndColon(text);
    }

    private static String[] splitByCommaAndColon(String text) {
        return text.split(DELIMITER);
    }
}
