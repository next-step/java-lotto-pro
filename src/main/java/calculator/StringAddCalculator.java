package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (!hasText(text))
            return 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (hasCustomDelimiter(m)) {
            String customDelimiter = m.group(1);
            String myText = m.group(2);
            return calculateSum(myText, customDelimiter);
        }
        return calculateSum(text, DEFAULT_DELIMITER);
    }

    private static int calculateSum(String text, String delimiter) {
        String[] strings = text.split(delimiter);
        int sum = 0;
        for (String string : strings) {
            int value = Integer.parseInt(string);
            if (value < 0) {
                throw new RuntimeException();
            }
            sum += value;
        }
        return sum;
    }

    private static boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

    private static boolean hasText(CharSequence str) {
        return (str != null && str.length() > 0 && containsText(str));
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}
