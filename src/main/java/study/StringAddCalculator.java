package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isNullOrEmptyString(input)) return 0;
        String[] numbers = splitInput(input);
        validatePositiveNumbers(numbers);
        if (isOnlyNumber(numbers)) return 1;
        return calculate(numbers);
    }
    private static void validatePositiveNumbers(String[] numbers) {
        for (String number : numbers) {
            validateNumber(number);
        }
    }

    private static String[] splitInput(String input) {
        String[] numbers = input.split(",|:");
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return numbers;
    }

    private static boolean isOnlyNumber(String[] numbers) {
        return numbers.length == 1;
    }

    private static void validateNumber(String number) {
        if (!number.matches("^[0-9]")) {
            throw new RuntimeException("0부터 9까지의 숫자만 허용합니다.");
        }
    }

    private static int calculate(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static boolean isNullOrEmptyString(String input) {
        return input == null || input.isEmpty();
    }
}
