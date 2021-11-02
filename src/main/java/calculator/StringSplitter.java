package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_DELIMETER = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] split(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMETER);
    }
}
