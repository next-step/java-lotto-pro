package calculator.add.string.utils;

import static calculator.add.string.constant.RegexConst.CUSTOM_DELIMITER_PATTERN;
import static calculator.add.string.constant.RegexConst.DEFAULT_DELIMITERS;

import java.util.regex.Matcher;

public class StringInputUtil {

    private StringInputUtil() {
    }

    public static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    public static String[] split(String input) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (customDelimiterMatcher.find()) {
            String customDelimiter = customDelimiterMatcher.group(1);
            return customDelimiterMatcher.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITERS);
    }

}
