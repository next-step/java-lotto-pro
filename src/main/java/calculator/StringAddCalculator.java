package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static String DEFAULT_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static int CUSTOM_PATTERN_DELIMITER_INDEX = 1;
    private final static int CUSTOM_SPLIT_DELIMITER_INDEX = 2;
    private final static Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private final static String INTEGER_PATTERN = "-?\\d+";

    public static int splitAndSum(String text) {

        if (isValidationCheckNullOrEmpty(text)) {
            return 0;
        }

        return getSum(splitTextToNumbers(splitText(text)));
    }

    private static boolean isValidationCheckNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int[] splitTextToNumbers(String[] splitText) {
        int[] resultNumbers = new int[splitText.length];

        for (int i = 0; i < splitText.length; i++) {
            resultNumbers[i] = stringToNumber(splitText[i]);
        }

        return resultNumbers;
    }

    private static int stringToNumber(String token) {
            if(!isNumber(token)){
                throw new IllegalArgumentException("숫자 값만 계산이 가능합니다.");
            }

            int resultNumber = Integer.parseInt(token);
            if(isNegativeNumber(resultNumber)){
                throw new IllegalArgumentException("음수 값은 입력할 수 없습니다.");
            }

            return resultNumber;
    }

    private static boolean isNumber(String token) {
        return token.matches(INTEGER_PATTERN);
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private static String[] splitText(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_PATTERN_DELIMITER_INDEX);
            return m.group(CUSTOM_SPLIT_DELIMITER_INDEX).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int getSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
