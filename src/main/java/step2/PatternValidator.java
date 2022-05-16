package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static boolean hasCustomDelimiter(final String numberWithDelimiter) {
        return CUSTOM_PATTERN.matcher(numberWithDelimiter).matches();
    }

    public static Matcher matcher(final String numberWithDelimiter) {
        return CUSTOM_PATTERN.matcher(numberWithDelimiter);
    }
}
