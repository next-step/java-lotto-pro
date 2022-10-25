package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final int MATCHER_GROUP_INDEX_FOR_DELIMITER = 1;
    private static final int MATCHER_GROUP_INDEX_FOR_TARGET_STRING = 2;

    private StringSplitter() {
        throw new IllegalStateException("Utility class");
    }

    public static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(MATCHER_GROUP_INDEX_FOR_DELIMITER);
            return matcher.group(MATCHER_GROUP_INDEX_FOR_TARGET_STRING).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER_REGEX);
    }
}
