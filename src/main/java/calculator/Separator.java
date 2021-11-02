package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    public static final String DEFAULT_SEPARATOR_REGEX = "[,:]";
    public static final Pattern CUSTOM_SEPARATOR = Pattern.compile("//(.)\n(.*)");

    private Separator() {
    }

    public static String[] split(String input) {
        Matcher matcher = CUSTOM_SEPARATOR.matcher(input);

        if (matcher.find()) {
            return splitByCustomSeparator(matcher);
        }

        return splitByDefaultSeparator(input);
    }

    private static String[] splitByCustomSeparator(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static String[] splitByDefaultSeparator(String input) {
        return input.split(DEFAULT_SEPARATOR_REGEX);
    }

}
