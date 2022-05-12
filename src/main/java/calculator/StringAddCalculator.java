package calculator;

import calculator.common.Constants;
import calculator.common.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return Constants.EMPTY_RETURN;
        }
        String[] splitNumbers = splitText(text);
        return sumNumbers(splitNumbers);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitText(String text) {
        if (useCustomDelimiter(text)) {
            return splitCustomDelimiter(text);
        }
        return text.split(Constants.DEFAULT_DELIMITER_REGEX);
    }

    private static String[] splitCustomDelimiter(String text) {
        Matcher matcher = Pattern.compile(Constants.CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return new String[0];
    }

    private static boolean useCustomDelimiter(String text) {
        return text.matches(Constants.CUSTOM_DELIMITER_REGEX);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            matchesPositiveNumber(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static void matchesPositiveNumber(String numberStr) {
        if (!numberStr.matches(Constants.POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }
}
