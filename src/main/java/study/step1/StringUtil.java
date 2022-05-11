package study.step1;

public class StringUtil {
    private static final String BRACKET_START_CHAR = "(";
    private static final String BRACKET_END_CHAR = ")";

    private StringUtil() {

    }

    public static String[] split(String str, String delimiter) {
        return str.split(delimiter);
    }

    public static String removeBrackets(String str) {
        String trimmedStr = str.trim();
        return trimmedStr.substring(trimmedStr.indexOf(BRACKET_START_CHAR) + 1, trimmedStr.indexOf(BRACKET_END_CHAR));
    }

    public static char getChar(String str, int index) {
        return str.charAt(index);
    }
}
