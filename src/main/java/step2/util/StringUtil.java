package step2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
    private static final String BASE_DELIMITER = "[,:]";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public StringUtil() {

    }

    public static String[] parseText(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(BASE_DELIMITER);
    }
}
