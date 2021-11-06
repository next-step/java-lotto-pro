package calculator.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final int SUM_IF_INPUT_IS_NULL_OR_EMPTY = 0;

    private static final int SEPARATOR_GROUP_INDEX = 1;
    private static final int EXPRESSION_GROUP_INDEX = 2;

    public static int splitAndSum(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return SUM_IF_INPUT_IS_NULL_OR_EMPTY;
        }
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            String pattern = matcher.group(SEPARATOR_GROUP_INDEX);
            return sum(matcher.group(EXPRESSION_GROUP_INDEX).split(pattern));
        }
        return sum(input.split(DEFAULT_SEPARATOR));
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
            .map(PositiveNumber::from)
            .reduce(PositiveNumber.from("0"), PositiveNumber::add)
            .positiveNumber();
    }
}
