package step2.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToStringArrayResolver {

    private static final String REGEX = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(REGEX);
    private static final int DELIMITER_GROUP = 1;
    private static final int SPLIT_SOURCE_GROUP = 2;
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final String EMPTY_SOURCE = "";
    private static final String DEFAULT_ELEMENT = "0";

    public static String[] resolve(String source) {
        if (sourceIsEmpty(source)) {
            return resolveSimple(source);
        }
        return resolveByDelimiter(source);
    }

    private static boolean sourceIsEmpty(String source) {
        return source == null || source.trim().equals(EMPTY_SOURCE);
    }

    private static String[] resolveSimple(String source) {
        try {
            return new String[]{String.valueOf(Integer.parseInt(source))};
        } catch (NumberFormatException e) {
            return new String[]{DEFAULT_ELEMENT};
        }
    }

    private static String[] resolveByDelimiter(String source) {
        try {
            Matcher delimiterMatcher = pattern.matcher(source);
            delimiterMatcher.find();
            return delimiterMatcher.group(SPLIT_SOURCE_GROUP).split(delimiterMatcher.group(DELIMITER_GROUP));
        } catch (IllegalStateException e) {
            return source.split(DELIMITER_COLON + "|" + DELIMITER_COMMA);
        }
    }
}
