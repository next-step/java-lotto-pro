package calculator.add.string.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInputSplit {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] split(String input) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (customDelimiterMatcher.find()) {
            String customDelimiter = customDelimiterMatcher.group(1);
            return customDelimiterMatcher.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITERS);
    }

}
