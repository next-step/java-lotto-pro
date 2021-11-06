package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitAndSum {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return customDelimiterAdd(matcher);
        }
        String[] numbers = text.split(DEFAULT_DELIMITER);
        return StringAddCalculator.stringAdd(numbers);
    }

    private static int customDelimiterAdd(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] numbers = matcher.group(2).split(customDelimiter);
        return StringAddCalculator.stringAdd(numbers);
    }
}
