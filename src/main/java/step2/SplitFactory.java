package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitFactory {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX  = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static String[] splitNumber(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return splitByCommaAndColon(text);
    }
    private static String[] splitByCommaAndColon(String text) {
        return text.split(DEFAULT_DELIMITER_REGEX);
    }
}
