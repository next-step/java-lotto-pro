package stringcalculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_DELIMITERS_REGEX = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int NUMBERS_GROUP = 2;

    public static String[] split(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            return m.group(NUMBERS_GROUP).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS_REGEX);
    }
}
