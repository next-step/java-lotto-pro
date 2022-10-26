package calculator;

import Utils.PatternUtils;
import message.ExceptionMessage;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String STAND_SEPARATORS = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\\n(.*)";

    public int sum(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return ZERO;
        }

        return Arrays.stream(split(numbers))
                    .filter(this::validCheck)
                    .mapToInt(Integer::parseInt)
                    .sum();
    }

    private String[] split(String numbers) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(numbers);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        return numbers.split(STAND_SEPARATORS);
    }

    private boolean validCheck(String numbers) {
        if (!PatternUtils.isPositiveNumber(numbers)) {
            throw new RuntimeException(ExceptionMessage.NOT_VALID_NUMBER);
        }

        return true;
    }
}
