package calculator.validator;

/**
 * @author : choi-ys
 * @date : 2022/05/12 6:41 오후
 */
public class DelimiterValidator {
    private static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public static boolean hasDelimiter(String input) {
        return hasComma(input) || hasColon(input);
    }

    public static boolean hasCustomDelimiter(String input) {
        return hasCustomDelimiterPrefix(input) && hasLineSeparator(input);
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
