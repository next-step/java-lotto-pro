package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitGenerator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final int DELIMITER = 1;
    private static final int VALUES = 2;

    public static String[] splitWithDelimiter(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(VALUES).split(matcher.group(DELIMITER));
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }
}
