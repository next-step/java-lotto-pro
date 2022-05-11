package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String[] DEFAULT_DELIMITERS = {",", ":"};
    public static final String REGEX_OR = "|";
    public static final String DEFAULT_DELIMITERS_REGEX = String.join(REGEX_OR, DEFAULT_DELIMITERS);
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final int[] MATCHER_GROUP_NUMBERS = {1, 2};
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    public static final Matcher MATCHER = PATTERN.matcher("");
    public static final String ILLEGAL_ARG_NOT_INT_EXCEPTION = "숫자(정수 형태) 이외의 값입니다.";
    public static final String ILLEGAL_ARG_NEGATIVE_EXCEPTION = "음수입니다.";

    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }

        List<Integer> numbers = parseZeroOrPositiveInts(splitInput(text));
        return numbers.stream()
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

    private static List<Integer> parseZeroOrPositiveInts(String[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : nums) {
            numbers.add(parseZeroOrPositiveInt(num));
        }

        return numbers;
    }

    private static int parseZeroOrPositiveInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        if (!isNumeric(s)) {
            throw new IllegalArgumentException(ILLEGAL_ARG_NOT_INT_EXCEPTION);
        }

        int result = Integer.parseInt(s);
        if (result < 0) {
            throw new IllegalArgumentException(ILLEGAL_ARG_NEGATIVE_EXCEPTION);
        }

        return result;
    }

    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
