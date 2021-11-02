import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int INPUT_NULL_OR_EMPTY_RETURN_VALUE = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String input) {

        if (isNullOrEmpty(input)) {
            return INPUT_NULL_OR_EMPTY_RETURN_VALUE;
        }

        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (customDelimiterMatcher.find()) {
            String customDelimiter = customDelimiterMatcher.group(1);
            String calculationTargetString = customDelimiterMatcher.group(2);

            return tokenSum(customDelimiterSplit(calculationTargetString, customDelimiter));
        }

        return tokenSum(defaultDelimiterSplit(input));
    }

    private static boolean isNullOrEmpty(final String input) {
        return input == null || input.isEmpty();
    }

    private static String[] customDelimiterSplit(final String input, final String customDelimiter) {
        return input.split(customDelimiter);
    }

    private static String[] defaultDelimiterSplit(final String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static int tokenSum(final String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            int number = stringToNumberConvert(token);
            negativeCheck(number);
            sum += number;
        }

        return sum;
    }

    private static void negativeCheck(final int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static int stringToNumberConvert(final String token) {
        try {
            return Integer.parseInt(token);
        }catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}