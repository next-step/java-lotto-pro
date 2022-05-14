package stringAddCalculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    public static final String INPUT_ERROR = "잘못된 값을 입력하였습니다.";

    public String[] checkTypeAndSplit(String input) throws IllegalAccessException {
        if (!input.startsWith("//")) {
            return splitNormal(input);
        }
        return splitCustom(input);
    }

    public String[] splitNormal(String input) {
        return input.split(",|:");
    }

    public String[] splitCustom(String input) throws IllegalAccessException {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        throw new IllegalAccessException(INPUT_ERROR);
    }
}
