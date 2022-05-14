package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_TARGET_INDEX = 2;
    private static Matcher matcher;

    private Splitter() {
    }

    public static String[] splitString(String input) {
        boolean isExist = hasCustomDelimiter(input);
        String delimiter = isExist ? matcher.group(CUSTOM_DELIMITER_INDEX) : DEFAULT_DELIMITERS;
        String targetString = isExist ? matcher.group(CUSTOM_TARGET_INDEX) : input;

        return targetString.split(delimiter);
    }

    private static boolean hasCustomDelimiter(String input) {
        matcher = pattern.matcher(input);
        return matcher.find();
    }
}
