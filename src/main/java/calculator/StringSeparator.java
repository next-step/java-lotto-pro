package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private static final String BASIC_SPLIT = ",|:";
    private static final Pattern CUSTOM_SPLIT = Pattern.compile("//(.)\n(.*)");

    private StringSeparator() {
    }

    public static String[] split(String input) {
        Matcher custom = CUSTOM_SPLIT.matcher(input);
        if (custom.find()) {
            return custom.group(2).split(custom.group(1));
        }
        return input.split(BASIC_SPLIT);
    }
}
