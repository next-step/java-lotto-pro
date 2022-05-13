package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String DEFAULT_SPLIT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_SPLIT_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Integer VALUE_IDX = 2;
    private static final Integer CUSTOM_SPLIT_DELIMITER_IDX = 1;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_SPLIT_DELIMITER_REGEX);

    private StringSplitter() {}

    public static String[] split(String text) {
        if (StringUtils.isEmpty(text)) {
            return new String[]{};
        }
        return splitDefaultOrCustomDelimiter(text);
    }

    private static String[] splitDefaultOrCustomDelimiter(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return splitByDelimiter(matcher.group(VALUE_IDX), matcher.group(CUSTOM_SPLIT_DELIMITER_IDX));
        }
        return splitByDelimiter(text, DEFAULT_SPLIT_DELIMITER_REGEX);
    }

    private static String[] splitByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }
}
