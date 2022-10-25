package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int ZERO = 0;

    private static final String SEPARATOR = ",|:";

    private static final String CUSTOM_SEPARATOR_REGEX = "\\/\\/(.)\n(.*)";

    private static final int CUSTOM_SEPARATOR_GROUP = 1;

    private static final int NUMBER_SEPARATOR_GROUP = 2;

    public static int splitAndSum(final String input) {
        if (isNullOrEmpty(input)) {
            return ZERO;
        }

        return sum(split(input));
    }

    private static boolean isNullOrEmpty(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    private static List<String> split(final String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(input);

        if(matcher.find()) {
            String group = matcher.group(CUSTOM_SEPARATOR_GROUP);
            return Arrays.asList(matcher.group(NUMBER_SEPARATOR_GROUP).split(group));
        }

        return Arrays.asList(input.split(SEPARATOR));
    }

    private static int sum(final List<String> splitNumbers) {
        return splitNumbers.stream()
            .mapToInt(Integer::parseInt)
            .peek(splitNumber -> checkNegative(splitNumber))
            .sum();
    }

    private static void checkNegative(final int splitNumber) {
        if (splitNumber < ZERO) {
            throw new RuntimeException("덧셈에 음수는 허용되지 않습니다.");
        }
    }
}
