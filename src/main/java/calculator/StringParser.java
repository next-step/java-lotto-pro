package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String DEFAULT_STRING_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_STRING_REGEXP = Pattern.compile("//(.)\n(.*)");

    public static String[] split(String input) {
        Matcher matcher = CUSTOM_STRING_REGEXP.matcher(input);
        if (matcher.matches()) {
            return splitCustomString(matcher);
        }

        return splitDefaultString(input);
    }

    private static String[] splitDefaultString(String input) {
        return input.split(DEFAULT_STRING_DELIMITER);
    }

    private static String[] splitCustomString(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }
}
