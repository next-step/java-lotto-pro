package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String BASIC_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final int CUSTOM_DELIMITER_PATTERN_SPLIT_DELIMITER_INDEX = 1;
    private static final int CUSTOM_DELIMITER_PATTERN_SPLIT_TARGET_INDEX = 2;

    public static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_PATTERN_SPLIT_DELIMITER_INDEX);
            return matcher.group(CUSTOM_DELIMITER_PATTERN_SPLIT_TARGET_INDEX).split(customDelimiter);
        }
        return text.split(BASIC_DELIMITER_REGEX);
    }
}
