package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final int DELIMITER_GROUP = 1;
    private static final int TOKENS_GROUP = 2;

    private Splitter() {
    }

    public static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP);
            return matcher.group(TOKENS_GROUP).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }
}
