package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.ErrorMessage.*;

public class StringAddCalculator {

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        for (String token : splitTokens(input)) {
            validateToken(token);
            int number = Integer.parseInt(token);
            validateNumber(number);
            result += number;
        }
        return result;
    }

    private static String[] splitTokens(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split("[,:]");
    }

    private static void validateToken(String token) {
        if (!token.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException(TOKEN_ERROR.getMessage());
        }
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(NUMBER_ERROR.getMessage());
        }
    }
}
