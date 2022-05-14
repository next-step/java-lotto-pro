package step2.calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : choi-ys
 * @date : 2022/05/14 10:27 오후
 */
public class DelimiterUtils {

    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final String COMMA_AND_COLON_DELIMITERS_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static boolean hasAnyDelimiters(String input) {
        return hasCommaOrColonDelimiters(input) || hasCustomDelimiter(input);
    }

    public static boolean hasCommaOrColonDelimiters(String input) {
        return hasCommaDelimiter(input) || hasColonDelimiter(input);
    }

    public static boolean hasCustomDelimiter(String input) {
        return customDelimiterMatcher(input).find();
    }

    public static String extractDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            return extractCustomDelimiterRegex(input);
        }
        if (hasCommaAndColonDelimiters(input)) {
            return COMMA_AND_COLON_DELIMITERS_REGEX;
        }
        if (hasCommaDelimiter(input)) {
            return COMMA_DELIMITER;
        }
        return COLON_DELIMITER;
    }

    public static String extractSplitTarget(String input) {
        if (hasCustomDelimiter(input)) {
            Matcher matcher = customDelimiterMatcher(input);
            matcher.find();
            return matcher.group(2);
        }
        return input;
    }

    public static String[] splitByDelimiterRegex(String input, String commaAndColonDelimitersRegex) {
        return input.split(commaAndColonDelimitersRegex);
    }

    private static Matcher customDelimiterMatcher(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
    }

    private static String extractCustomDelimiterRegex(String input) {
        Matcher matcher = customDelimiterMatcher(input);
        matcher.find();
        return matcher.group(1);
    }

    private static boolean hasCommaAndColonDelimiters(String input) {
        return hasCommaDelimiter(input) && hasColonDelimiter(input);
    }

    private static boolean hasCommaDelimiter(String input) {
        return input.contains(COMMA_DELIMITER);
    }

    private static boolean hasColonDelimiter(String input) {
        return input.contains(COLON_DELIMITER);
    }
}
