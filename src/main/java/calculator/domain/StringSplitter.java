package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_INPUT_INDEX = 2;


    private StringSplitter() {
    }

    public static String[] split(String input) {
        Matcher matcher = matcher(input);
        if (isCustomSplitPattern(matcher)) {
            return splitByPattern(matcher);
        }
        return splitByDelimiter(input);
    }

    private static String[] splitByDelimiter(String input) {
        return input.split(DELIMITER);
    }

    private static String[] splitByPattern(Matcher matcher) {
        String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
        return matcher.group(CUSTOM_INPUT_INDEX).split(customDelimiter);
    }

    private static Matcher matcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }

    private static boolean isCustomSplitPattern(Matcher matcher) {
        return matcher.find();
    }
}
