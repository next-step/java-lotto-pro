package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final int ZERO = 0;
    public static final String REGEX_COMMA_OR_COLON_SEPARATOR = ",|:";
    public static final String REGEX_CUSTOM_SEPARATOR = "//(.)\n(.*)";
    public static final String ERROR_MESSAGE_NEGATIVE = "음수는 입력 불가능 합니다.";
    public static final String ERROR_MESSAGE_ONLY_NUMBER = "숫자 이외의 값은 입력 불가능합니다.";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNull(input) || input.isEmpty()) {
            return ZERO;
        }

        String[] split = splitText(input);
        validNumbers(split);
        return sum(split);
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static String[] splitText(String input) {
        Matcher matcher = Pattern.compile(REGEX_CUSTOM_SEPARATOR).matcher(input);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            return matcher.group(2).split(customSeparator);
        }
        return input.split(REGEX_COMMA_OR_COLON_SEPARATOR);
    }

    private static void validNumbers(String[] numbers) {
        for (String number : numbers) {
            try {
                validNegative(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new RuntimeException(ERROR_MESSAGE_ONLY_NUMBER);
            }
        }
    }

    private static void validNegative(int number) {
        if (number < ZERO) {
            throw new RuntimeException(ERROR_MESSAGE_NEGATIVE);
        }
    }

    private static int sum(String[] split) {
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}