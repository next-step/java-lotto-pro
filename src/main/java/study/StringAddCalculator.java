package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 1;
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static Matcher matcher;
    private static String[] numbers;
    public static int splitAndSum(String text) {
        matcher = CUSTOM_PATTERN.matcher(text);

        if(text == null || text.isEmpty()){
            return 0;
        }

        numbers=splitText(text);

        return sumNumbers();
    }

    private static String[] splitText(String text) {

        if (matcher.find()) {
            String customToken = matcher.group(NUM_1);
            return matcher.group(NUM_2).split(customToken);
        }

        return text.split(DELIMITER);
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
            throw new IllegalArgumentException("양수값만 입력해주세요!!");
        }
    }

}
