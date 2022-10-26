package step2;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_EMPTY_RETURN = 0;
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX  = "//(.)\n(.*)";
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";
    private static final String NOT_POSITIVE_NUMBER = "0~9 사이의 숫자가 아닙니다.";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);



    public static int splitAndSum(String text) {
        if (isStringNullOrEmpty(text)) {
            return DEFAULT_EMPTY_RETURN;
        }
        String[] splitNumbers = splitNumber(text);
        validateNumbersPositive(splitNumbers);
        return addAllNumbers(splitNumbers);
    }

    private static void validateNumbersPositive(String[] splitNumbers) {
        boolean isValidate = Arrays.stream(splitNumbers).allMatch(number->number.matches(POSITIVE_NUMBER_REGEX));
        if (!isValidate){
            throw new RuntimeException(NOT_POSITIVE_NUMBER);
        }
    }

    private static int addAllNumbers(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .mapToInt(Integer::parseInt).sum();
    }

    private static boolean isStringNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitNumber(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return splitByCommaAndColon(text);
    }

    private static String[] splitByCommaAndColon(String text) {
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

}
