package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static List<String> splitNumbers(String input) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (delimiterMatcher.find()) {
            String customDelimiter = delimiterMatcher.group(1);
            return Arrays.asList(delimiterMatcher.group(2).split(customDelimiter));
        }
        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }
}
