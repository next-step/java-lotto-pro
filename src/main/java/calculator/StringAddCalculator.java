package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.ErrorMessage.*;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return sum(split(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split("[,:]");
    }

    private static int sum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            validateToken(token);
            int number = Integer.parseInt(token);
            validateNumber(number);
            result += number;
        }
        return result;
    }

    private static void validateToken(String token) {
        if (!token.matches(NUMBER_REGEX)) {
            throw new RuntimeException(TOKEN_ERROR.getMessage());
        }
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(NUMBER_ERROR.getMessage());
        }
    }
}
