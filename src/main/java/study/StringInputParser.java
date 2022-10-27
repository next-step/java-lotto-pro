package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInputParser {
    public static final String DEFAULT_SPLIT_DELIMITER_REGEX = ",|:";
    public static final String CUSTOM_SPLIT_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String CUSTOM_DELIMITER = "//";

    public static String[] toStringArray(String input) {
        if (input.contains(CUSTOM_DELIMITER)) {
            Matcher m = Pattern.compile(CUSTOM_SPLIT_DELIMITER_REGEX).matcher(input);
            if (m.find()) {
                String customDelimiter = m.group(1);
                return m.group(2).split(customDelimiter);
            }
        }
        return input.split(DEFAULT_SPLIT_DELIMITER_REGEX);
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
