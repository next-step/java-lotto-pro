package calculator;

import Utils.PatternUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String NOT_VALID_NUMBER = "양수만 입력 가능합니다.";
    private static final int ZERO = 0;
    private static final String STAND_SEPARATORS_EXPRESSION = ",|:";
    private static final String CUSTOM_SEPARATOR_EXPRESSION = "//(.)\\n(.*)";
    private static final int CUSTOM_SEPARATOR_EXPRESSION_INDEX = 1;
    private static final int CUSTOM_SEPARATOR_TARGET_INDEX = 2;

    public int sum(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return ZERO;
        }

        return Arrays.stream(split(numbers.trim()))
                    .mapToInt((number) -> {
                        validCheck(number);
                        return Integer.parseInt(number);
                    })
                    .sum();
    }

    private String[] split(String numbers) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_EXPRESSION).matcher(numbers);
        if (matcher.find()) {
            return matcher.group(CUSTOM_SEPARATOR_TARGET_INDEX).split(matcher.group(CUSTOM_SEPARATOR_EXPRESSION_INDEX));
        }

        return numbers.split(STAND_SEPARATORS_EXPRESSION);
    }

    private boolean validCheck(String numbers) {
        if (!PatternUtils.isPositiveNumber(numbers)) {
            throw new RuntimeException(NOT_VALID_NUMBER);
        }

        return true;
    }
}
