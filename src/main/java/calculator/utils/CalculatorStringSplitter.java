package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringSplitter {
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";

    public static String[] stringSplit(String text) {
        Matcher customSplitMatcher = Pattern.compile(CUSTOM_REGEX).matcher(text);

        if (customSplitMatcher.find()) {
            String customDelimiter = customSplitMatcher.group(1);
            return customSplitMatcher.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_REGEX);
    }

}
