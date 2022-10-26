package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String DEFAULT_NUMBER = "0";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int STRING_GROUP = 2;

    public static List<String> split(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.singletonList(DEFAULT_NUMBER);
        }
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            return Arrays.asList(matcher.group(STRING_GROUP).split(delimiter));
        }
        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }
}
