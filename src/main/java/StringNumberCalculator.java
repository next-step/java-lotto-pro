import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringNumberCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private StringNumberCalculator() {
    }

    public static int splitAndSum(final String input) {
        if (isEmpty(input)) {
            return 0;
        }
        return Arrays.stream(split(input.trim()))
            .map(String::trim)
            .map(StringNumberCalculator::parseInt)
            .map(PositiveNumber::new)
            .reduce(PositiveNumber.ZERO, PositiveNumber::plus)
            .intValue();
    }

    private static String[] split(final String input, final String delimiter) {
        return input.split(delimiter);
    }

    private static String[] split(final String input) {
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            return split(input, DEFAULT_DELIMITER);
        }
        return split(matcher.group(2), matcher.group(1));
    }

    private static int parseInt(final String value) {
        if (isEmpty(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    private static boolean isEmpty(final String input) {
        return input == null || input.isEmpty();
    }

}
