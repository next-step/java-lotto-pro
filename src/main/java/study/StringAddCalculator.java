package study;

import study.utils.NumberUtils;
import study.utils.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    private StringAddCalculator() {
        throw new UnsupportedOperationException();
    }

    public static int splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) {
            return NumberUtils.ZERO;
        }

        if (StringUtils.isNumber(text)) {
            return Integer.parseInt(text);
        }

        String[] strings = split(text);
        return sum(strings);
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] strings) {
        return Arrays.stream(strings)
                .peek(StringAddCalculator::validateString)
                .map(StringUtils::toNumber)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static void validateString(String str) {
        int number = StringUtils.toNumber(str);
        if (NumberUtils.isNegative(number)) {
            throw new RuntimeException(String.format("%s: %s", StringUtils.IS_STRING_NEGATIVE_NUMBER, number));
        }
    }
}
