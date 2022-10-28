package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]*$";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int EXPRESSION_GROUP = 2;


    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        return Arrays.stream(split(text))
                .sum();
    }

    private static int[] split(String text) {

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        String delimiter = DEFAULT_DELIMITER;

        if (matcher.find()) {
            delimiter = delimiter + "|" + matcher.group(CUSTOM_DELIMITER_GROUP);
            text = matcher.group(EXPRESSION_GROUP);
        }

        return Arrays.stream(text.split(delimiter))
                .mapToInt(StringAddCalculator::stringToInt)
                .toArray();
    }

    private static int stringToInt(String token) {
        if (!token.matches(POSITIVE_NUMBER_REGEX)) {
            throw new RuntimeException("양수의 숫자만 입력 가능합니다.");
        }

        return Integer.parseInt(token);
    }

    private static Boolean isEmpty(String numbers) {
        return numbers == null || numbers.trim().isEmpty();
    }


}
