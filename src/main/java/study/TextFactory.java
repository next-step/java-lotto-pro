package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFactory {

    public static final String CUSTOM_DELIMETER_PATTERN =  "//(.)\n(.*)";

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMETER_PATTERN);

    public static Text createText(String text) {

        if(isCustomed(text)) {
            return constructCustomedText(text);
        }

        return new Text(text);
    }

    private static boolean isCustomed(final String text) {
        return pattern.matcher(text).find();
    }

    private static Text constructCustomedText(final String text) {
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        return new CustomedText(matcher.group(2), matcher.group(1));
    }
}
