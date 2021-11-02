package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitDelimiter {
    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.*)\n(.*)");
    public static final int MATCHER_NUMBER_INDEX = 2;
    public static final int MATCHER_DELIMITER_INDEX = 1;

    public static String[] stringSplit(String input) {
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);
        if (matcher.find()) {
            return splitDelimiterOfCustom(matcher.group(MATCHER_NUMBER_INDEX), matcher.group(MATCHER_DELIMITER_INDEX));
        }

        return splitDelimiterOfDefault(input);
    }

    public static String[] splitDelimiterOfDefault(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    public static String[] splitDelimiterOfCustom(String input, String delimiter) {
        return input.split(delimiter);
    }

}
