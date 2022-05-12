package stringAddCalculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
    public static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    public static final String INPUT_ERROR = "잘못된 값을 입력하였습니다.";

    public static String[] splitNormal(String input) {
        return input.split(",|:");
    }

    public static String[] splitCustom(String input) throws IllegalAccessException {
        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        throw new IllegalAccessException(INPUT_ERROR);
    }
}
