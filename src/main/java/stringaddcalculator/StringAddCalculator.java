package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_RESULT = 0;
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int NUMBER_GROUP_INDEX = 2;
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String COMMA_OR_COLON_PATTERN = ",|:";
    private static final String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String inputText) {
        if (isNullOrEmpty(inputText)) {
            return DEFAULT_RESULT;
        }
        if (isContainsCustomSeparator(inputText)) {
            return calculateContainsCustomSeparator(inputText);
        }
        if (isContainsCommaOrColon(inputText)) {
            return calculateContainsCommaOrColon(inputText);
        }
        return changeStringToInt(inputText);
    }

    private static Matcher getMatcher(String inputText) {
        return Pattern.compile(CUSTOM_SEPARATOR_PATTERN).matcher(inputText);
    }

    private static boolean isContainsCustomSeparator(String inputText) {
        Matcher matcher = getMatcher(inputText);
        return matcher.find();
    }

    private static int calculateContainsCustomSeparator(String inputText) {
        Matcher matcher = getMatcher(inputText);
        int sum = 0;
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            String[] numbers = matcher.group(NUMBER_GROUP_INDEX).split(customDelimiter);
            sum = calculateSum(numbers);
        }
        return sum;
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += changeStringToInt(number);
        }
        return sum;
    }

    private static int changeStringToInt(String stringNumber) {
        int num = Integer.parseInt(stringNumber);
        if (num < 0) {
            throw new RuntimeException(ExceptionMessage.NEGATIVE_EXCEPTION_MESSAGE + "(입력값: " + num + ")");
        }
        return num;
    }

    private static boolean isNullOrEmpty(String inputText) {
        if (inputText == null) {
            return true;
        }
        if (inputText.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isContainsCommaOrColon(String inputText) {
        if (inputText.contains(COMMA)) {
            return true;
        }
        if (inputText.contains(COLON)) {
            return true;
        }
        return false;
    }

    private static int calculateContainsCommaOrColon(String inputText) {
        String[] numbers = inputText.split(COMMA_OR_COLON_PATTERN);
        return calculateSum(numbers);
    }
}
