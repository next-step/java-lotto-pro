package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private final static String DEFAULT_DELIMITERS = ",|:";
    private final static String CUSTOM_DELIMITER_REGEX = "^//(.)\n(.*)";
    private final static Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static Matcher matcher;

    public static String[] splitString(String input) {
        boolean isExist = hasCustomDelimiter(input);
        String delimiter = isExist ? matcher.group(1) : DEFAULT_DELIMITERS;
        String targetString = isExist ? matcher.group(2) : input;

        return targetString.split(delimiter);
    }

    private static boolean hasCustomDelimiter(String input) {
        matcher = pattern.matcher(input);
        return matcher.find();
    }
}
