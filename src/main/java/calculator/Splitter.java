package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private Splitter() {
    }

    public static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }
}
