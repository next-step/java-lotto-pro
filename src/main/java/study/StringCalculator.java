package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_REGEX = "//(.+)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX);
    private static final int CUSTOM_DELIMITER = 1;
    private static final int SPLIT_WORD = 2;

    public static String[] split(final String word) {
        Matcher matcher = CUSTOM_PATTERN.matcher(word);
        if (matcher.find()) {
            return splitCustom(matcher);
        }
        return splitDefault(word);
    }

    private static String[] splitCustom(final Matcher matcher) {
        return matcher.group(SPLIT_WORD).split(matcher.group(CUSTOM_DELIMITER));
    }

    private static String[] splitDefault(final String word) {
        return word.split(DEFAULT_DELIMITER);
    }



}
