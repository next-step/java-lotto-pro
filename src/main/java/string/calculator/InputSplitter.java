package string.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {
    private static final String DEFAULT_DELIMITER_REGEX = "[:,]";
    private final String input;

    public InputSplitter(String input) {
        this.input = input;
    }

    public String[] split() {
        final Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            return matcher.group(2).split(String.format("\\%s", customDelimiter));
        }
        return input.split(InputSplitter.DEFAULT_DELIMITER_REGEX);
    }
}
