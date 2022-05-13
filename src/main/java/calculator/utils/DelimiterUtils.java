package calculator.utils;

/**
 * @author : choi-ys
 * @date : 2022/05/12 6:41 오후
 */
public class DelimiterUtils {

    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public static boolean hasDelimiter(String input) {
        return hasComma(input) || hasColon(input);
    }

    public static String[] splitByCommaOrColon(String given) {
        if (hasComma(given) && hasColon(given)) {
            String regexFormat = String.format("%s%s%s", COMMA, "|", COLON);
            return given.split(regexFormat);
        }
        if (hasComma(given)) {
            return given.split(COMMA);
        }
        return given.split(COLON);
    }

    public static boolean hasCustomDelimiter(String input) {
        return hasCustomDelimiterPrefix(input) && hasLineSeparator(input);
    }

    public static String[] splitByCustomDelimiter(String given) {
        String customDelimiter = extractCustomDelimiter(given);
        return removeCustomDelimiterArea(given).split(customDelimiter);
    }

    private static String extractCustomDelimiter(String input) {
        return input.split(LINE_SEPARATOR)[0].split(CUSTOM_DELIMITER_PREFIX)[1];
    }

    private static String removeCustomDelimiterArea(String given) {
        int LINE_SEPARATOR_INDEX = given.indexOf(LINE_SEPARATOR) + 1;
        return given.substring(LINE_SEPARATOR_INDEX);
    }

    private static boolean hasComma(String input) {
        return input.contains(COMMA);
    }

    private static boolean hasColon(String input) {
        return input.contains(COLON);
    }

    private static boolean hasLineSeparator(String input) {
        return input.contains(LINE_SEPARATOR);
    }

    private static boolean hasCustomDelimiterPrefix(String input) {
        return input.contains(CUSTOM_DELIMITER_PREFIX);
    }
}
