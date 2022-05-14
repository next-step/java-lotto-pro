package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static Matcher matcher;
private Splitter() {}
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
