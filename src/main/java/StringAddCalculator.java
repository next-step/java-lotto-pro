import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern delimiterPattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        Matcher delimiterMatcher = delimiterPattern.matcher(text);
        String delimiter = generateDelimiter(delimiterMatcher);
        text = removeDelimiter(text, delimiterMatcher);
        String[] split = text.split(delimiter);
        return sum(split);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String generateDelimiter(Matcher delimiterMatcher) {
        delimiterMatcher.reset();
        StringBuilder delimiterBuilder = new StringBuilder();
        delimiterBuilder.append("[,:");
        if (delimiterMatcher.find()) {
            delimiterBuilder.append(delimiterMatcher.group(1));
        }
        return delimiterBuilder.append("]").toString();
    }

    private static String removeDelimiter(String text, Matcher delimiterMatcher) {
        delimiterMatcher.reset();
        if (delimiterMatcher.find()) {
            return delimiterMatcher.group(2);
        }
        return text;
    }

    private static int sum(String[] split) {
        return Arrays.stream(split)
                .mapToInt(StringAddCalculator::parseInt)
                .peek(StringAddCalculator::checkMinus)
                .sum();
    }

    private static int parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            throw new IllegalArgumentException("Text must be in numeric form");
        }
    }

    private static void checkMinus(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than or equal to 0");
        }
    }
}
