package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    public static final Pattern DEFAULT_PATTERN = Pattern.compile("[,:]");
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final int FIRST = 1;
    public static final int SECOND = 2;

    public static Numbers split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(FIRST);
            input = matcher.group(SECOND);
            return new Numbers(input.split(customDelimiter));
        }
        return new Numbers(DEFAULT_PATTERN.split(input));
    }
}
