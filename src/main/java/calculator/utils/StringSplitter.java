package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_SPLIT_DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_SPLIT_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final Integer MATCHER_GROUP_VALUE_INDEX = 2;
    private static final Integer MATCHER_GROUP_CUSTOM_SPLIT_DELIMITER_INDEX = 1;

    private StringSplitter() {
        throw new AssertionError();
    }

    public static String[] split(String string) {
        if (StringUtil.isNullOrEmpty(string)) {
            return new String[]{};
        }

        return splitWithRules(string);
    }

    private static String[] splitWithRules(String string) {
        Matcher matcher = CUSTOM_SPLIT_DELIMITER_PATTERN.matcher(string);
        if (matcher.find()) {
            return splitByDelimiter(
                    matcher.group(MATCHER_GROUP_VALUE_INDEX),
                    matcher.group(MATCHER_GROUP_CUSTOM_SPLIT_DELIMITER_INDEX)
            );
        }

        return splitByDelimiter(string, DEFAULT_SPLIT_DELIMITER_REGEX);
    }

    private static String[] splitByDelimiter(String string, String delimiter) {
        return string.split(delimiter);
    }
}
