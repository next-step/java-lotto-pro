package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_EXPRESSION = "//(.)\n(.*)";


    public static String[] separator(String inputString) {
        return inputString.split(SEPARATOR);
    }

    public static String[] customSeparator(String inputString) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_EXPRESSION).matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            for (String token : tokens) {
                System.out.println("token = " + token);
            }
            return tokens;
        }
        return new String[]{inputString};
    }
}
