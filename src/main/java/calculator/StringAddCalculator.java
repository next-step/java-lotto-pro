package calculator;

import calculator.common.Constants;
import calculator.common.ErrorMessage;

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
        return text.split(Constants.DEFAULT_DELIMITER);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            matchesPositiveNumber(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static void matchesPositiveNumber(String text) {
        if (!text.matches(Constants.POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }
}
