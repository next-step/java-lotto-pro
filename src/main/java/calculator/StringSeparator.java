package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private static final String BASIC_SEPARATOR_PATTERN = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int BODY = 2;
    private static final int CUSTOM_SEPARATOR = 1;

    private StringSeparator() {
    }

    public static String[] split(String input) {
        Matcher custom = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (custom.find()) {
            return custom.group(BODY).split(custom.group(CUSTOM_SEPARATOR));
        }
        return input.split(BASIC_SEPARATOR_PATTERN);
    }
}
