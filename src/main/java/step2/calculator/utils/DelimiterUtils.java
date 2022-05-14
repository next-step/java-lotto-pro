package step2.calculator.utils;

/**
 * @author : choi-ys
 * @date : 2022/05/14 10:27 오후
 */
public class DelimiterUtils {

    public static final String COMMA_DELIMITER = ",";
    public static final String COLON_DELIMITER = ":";
    public static final String COMMA_AND_COLON_DELIMITERS_REGEX = ",|:";

    public static boolean hasCommaOrColonDelimiters(String input) {
        return hasCommaDelimiter(input) || hasColonDelimiter(input);
    }

    public static String extractDelimiter(String input) {
        if (hasCommaAndColonDelimiters(input)) {
            return COMMA_AND_COLON_DELIMITERS_REGEX;
        }

        if (hasCommaDelimiter(input)) {
            return COMMA_DELIMITER;
        }
        return COLON_DELIMITER;
    }

    public static String[] splitByDelimiterRegex(String input, String commaAndColonDelimitersRegex) {
        return input.split(commaAndColonDelimitersRegex);
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
