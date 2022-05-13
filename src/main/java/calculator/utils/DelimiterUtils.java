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
    public static final String REGEX_FORMAT = String.format("%s%s%s", COMMA, "|", COLON);

    public static boolean hasDelimiter(String input) {
        return hasComma(input) || hasColon(input);
    }

    public static String[] splitByCommaOrColon(String input) {
        if (hasComma(input) && hasColon(input)) {
            return input.split(REGEX_FORMAT);
        }
        if (hasComma(input)) {
            return input.split(COMMA);
        }
        return input.split(COLON);
    }

    public static boolean hasCustomDelimiter(String input) {
        return hasCustomDelimiterPrefix(input) && hasLineSeparator(input);
    }

    public static String[] splitByCustomDelimiter(String input) {
        String customDelimiter = extractCustomDelimiter(input);
        return removeCustomDelimiterArea(input).split(customDelimiter);
    }

    private static String extractCustomDelimiter(String input) {
        return input.split(LINE_SEPARATOR)[0].split(CUSTOM_DELIMITER_PREFIX)[1];
    }

    private static String removeCustomDelimiterArea(String inpu) {
        int LINE_SEPARATOR_INDEX = inpu.indexOf(LINE_SEPARATOR) + 1;
        return inpu.substring(LINE_SEPARATOR_INDEX);
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
