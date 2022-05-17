package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    public static final String[] DEFAULT_DELIMITERS = {",", ":"};
    public static final String REGEX_OR = "|";
    public static final String DEFAULT_DELIMITERS_REGEX = String.join(REGEX_OR, DEFAULT_DELIMITERS);
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final int[] MATCHER_GROUP_NUMBERS = {1, 2};
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    public static final Matcher MATCHER = PATTERN.matcher("");

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }

        String[] nums = splitInput(text);
        UnsignedIntegers unsignedIntegers = new UnsignedIntegers(nums);
        return unsignedIntegers.getNumbers()
                .stream()
                .reduce(0, Integer::sum);
    }

    private static String[] splitInput(String text) {
        MATCHER.reset(text);

        if (!MATCHER.find()) {
            return text.split(DEFAULT_DELIMITERS_REGEX);
        }

        String customDelimiter = MATCHER.group(MATCHER_GROUP_NUMBERS[0]);
        return MATCHER.group(MATCHER_GROUP_NUMBERS[1])
                .split(DEFAULT_DELIMITERS_REGEX + REGEX_OR + customDelimiter);
    }
}
