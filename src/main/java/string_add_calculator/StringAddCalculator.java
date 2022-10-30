package string_add_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String splitter = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private static final char MIN_INT_VALUE = 48;
    private static final char MAX_INT_VALUE = 59;

    private StringAddCalculator() {

    }

    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        String[] numbers = splitText(text);
        if(numbers.length == 0) {
            throw new IllegalArgumentException("구분자 사이에 숫자를 입력해주세요.");
        }
        int result = 0;
        for(String number : numbers) {
            result += toInt(number);;
        }
        return result;
    }

    private static String[] splitText(String text) {
        String[] numbers = text.split(splitter);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            numbers = matcher.group(2).split(customDelimiter + "|" + splitter);
        }
        return numbers;
    }

    public static int toInt(String number) {
        char[] arr = number.toCharArray();
        for(char ch : arr) {
            charIntValueCheck(ch);
        }
        return Integer.parseInt(number);
    }

    public static void charIntValueCheck(char ch) {
        if(!isCharIntValue(ch)) {
            throw new IllegalArgumentException("올바른 숫자값이 아닙니다.");
        }
    }

    public static boolean isCharIntValue(char ch) {
        return ch >= MIN_INT_VALUE && ch <= MAX_INT_VALUE;
    }
}
