package study;

import study.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    private StringAddCalculator() {
        throw new UnsupportedOperationException();
    }

    public static int splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        if (StringUtils.isNumber(text)) {
            return Integer.parseInt(text);
        }

        split(text);
        return 0;
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }
}
