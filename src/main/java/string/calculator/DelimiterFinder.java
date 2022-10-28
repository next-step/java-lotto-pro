package string.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterFinder {
    private static final String DEFAULT_DELIMITER_REGEX = "[:,]";
    private final String input;

    public DelimiterFinder(String input) {
        this.input = input;
    }

    public String find() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (!matcher.find()) {
            return DelimiterFinder.DEFAULT_DELIMITER_REGEX;
        }
        return matcher.group(1);
    }
}
