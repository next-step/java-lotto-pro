package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private static final String NEGATIVE_NUMBER_MESSAGE = "음수는 포함될 수 없습니다";

    public static int splitAndSum(String text) {
        if (isEmptyOrNull(text)) return DEFAULT_VALUE;
        String[] tokens = splitText(text);
        return sumNumbers(tokens);
    }

    private static boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

    private static int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(StringAddCalculator::convertToInt)
                .sum();
    }

    private static String[] splitText(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if(matcher.find()){
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static int convertToInt(String number){
        int intValue = Integer.parseInt(number);
        if(intValue < 0) throw new RuntimeException(NEGATIVE_NUMBER_MESSAGE);
        return intValue;
    }


}
