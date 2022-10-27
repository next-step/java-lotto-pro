package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String[] numbers;
    public static int splitAndSum(String text) {

        if(text == null || text.isEmpty()) return 0;

        numbers=splitText(text);

        return sumNumbers();
    }

    private static String[] splitText(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (matcher.find()) {
            String customToken = matcher.group(1);
            return matcher.group(2).split(customToken);
        }

        return text.split(",|:");
    }

    private static int sumNumbers() {
        int sum = 0;
        for(String num : numbers){
            sum += stringToInt(num);
        }
        return sum;
    }

    private static int stringToInt(String num) {
        int intValue = Integer.parseInt(num);
        validateNumber(intValue);
        return intValue;
    }

    private static void validateNumber(int intValue) {
        if (intValue < 0) {
            throw new RuntimeException("양수값만 입력해주세요!!");
        }
    }

}
