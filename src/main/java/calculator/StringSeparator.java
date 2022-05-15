package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private static final String BASIC_SPLIT = ",|:";
    private static final Pattern CUSTOM_SPLIT = Pattern.compile("//(.)\n(.*)");

    private static final int ELEMENTS = 2;
    private static final int CUSTOM_DELIMITER = 1;

    private StringSeparator() {
    }

    public static String[] split(String input) {
        Matcher custom = CUSTOM_SPLIT.matcher(input);
        if (custom.find()) {
            return custom.group(ELEMENTS).split(custom.group(CUSTOM_DELIMITER));
        }
        return input.split(BASIC_SPLIT);
    }
}
