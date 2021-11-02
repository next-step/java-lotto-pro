package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitDelimiter {
    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.*)\n(.*)");

    public static String[] stringSplit(String input) {
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);
        if (matcher.find()) {
            return splitDelimiterOfCustom(matcher);
        }

        return splitDelimiterOfDefault(input);
    }

    public static String[] splitDelimiterOfDefault(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    public static String[] splitDelimiterOfCustom(Matcher matcher) {
        return matcher.group(2).split(matcher.group(1));
    }

}
