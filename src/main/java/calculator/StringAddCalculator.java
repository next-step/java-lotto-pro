package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String NUMBER_REGEX = "^[1-9]*$";
    private static final String ERROR_MSG_NOT_NUMBER = "0 이상의 정수만 입력 가능합니다.";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        List<String> numbers = splitToNumbers(input);
        return calculateSum(numbers);
    }

    private static List<String> splitToNumbers(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.asList(m.group(2).split(customDelimiter));
        }
        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

    private static int calculateSum(List<String> numbers) {
        int sum = 0;
        for (String number : numbers) {
            validateNumberCheck(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static void validateNumberCheck(String number) {
        if (!Pattern.matches(NUMBER_REGEX, number)) {
            throw new RuntimeException(ERROR_MSG_NOT_NUMBER);
        }
    }
}
