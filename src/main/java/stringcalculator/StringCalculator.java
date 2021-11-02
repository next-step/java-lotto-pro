package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            return tokens;
        }
        return new String[]{inputString};
    }

    public static int calculate(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        int result = 0;
        List<String> separatedList = new ArrayList<>();
        String[] customSeparatedStrings = customSeparator(inputString);

        for (String customSeparatedString : customSeparatedStrings) {
            separatedList.addAll(Arrays.asList(separator(customSeparatedString)));
        }

        for (String separatedString : separatedList) {
            int number = Integer.parseInt(separatedString);
            validateNumber(number);
            result += number;
        }
        return result;
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수를 입력하면 안됩니다.");
        }
    }
}
