package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSplit {
    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\\n(.*)");

    public static String[] split(String text) {
        Matcher customMatcher = CUSTOM_DELIMITER.matcher(text);
        if (customMatcher.find()) {
            return splitByCustomDelimiter(customMatcher);
        }
        return text.split(DELIMITER);
    }

    private static String[] splitByCustomDelimiter(Matcher customMatcher) {
        String customDelimiter = customMatcher.group(1);
        return customMatcher.group(2).split(customDelimiter);
    }
}
