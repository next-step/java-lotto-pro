package stringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitInput = splitString(input);
        int result = calculateStringSum(splitInput);
        return result;
    }

    private static String[] splitString(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return str.split(",|:");
    }

    private static int calculateStringSum(String[] strs) {
        int result = 0;
        for (String str : strs) {
            result += parseStringToPositiveInteger(str);
        }
        return result;
    }

    private static int parseStringToPositiveInteger(String str) {
        int i = parseStringToInteger(str);
        if (i < 0) {
            throw new IllegalArgumentException("[Error] 음수는 입력할 수 없습니다.");
        }
        return i;
    }

    private static int parseStringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 올바른 숫자가 아닙니다.");
        }
    }
}
