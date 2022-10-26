package study.splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_DELIMITER_NUMBERS_GROUP = 2;

    public static String[] split(String str) {
        if(useCustomDelimiter(str)) {
            return splitCustom(str);
        }
        return str.split(DEFAULT_DELIMITER);
    }

    private static boolean useCustomDelimiter(String str) {
        return Pattern.matches(CUSTOM_DELIMITER_PATTERN.pattern(), str);
    }

    private static String[] splitCustom(String str) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(str);
        if(m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            return m.group(CUSTOM_DELIMITER_NUMBERS_GROUP).split(customDelimiter);
        }
        throw new RuntimeException("[ERROR] The given string cannot be matched with a custom pattern.");
    }
}
