package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {
    private static final String DELIMITER = ",|:";
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] split(String text) {
        if (text == null) {
            text = "";
        }
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customToken = matcher.group(NUM_1);
            return matcher.group(NUM_2).split(customToken);
        }

        return text.split(DELIMITER);
    }

}
