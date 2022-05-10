package calculator;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String JOINER_PIPE = "|";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수가 입력되었습니다. 0 이상 값을 입력해주세요.";
    public static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자 이외의 값이 입력되었습니다. 숫자를 입력해주세요.";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSum(split(input));
    }

    private static int getSum(String[] splits) {
        return Arrays.stream(splits)
                .mapToInt(StringAddCalculator::parseNotNegativeInt)
                .sum();
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        StringJoiner stringJoiner = new StringJoiner(JOINER_PIPE);
        stringJoiner.add(DELIMITER_COMMA);
        stringJoiner.add(DELIMITER_COLON);
        return input.split(stringJoiner.toString());
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int parseNotNegativeInt(String input) {
        try {
            int parseInt = Integer.parseInt(input);
            validNotNegativeNumber(parseInt);
            return parseInt;
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validNotNegativeNumber(int number) {
        if (isNegativeNumber(number)) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }
}
