package calculator.utils;

public class StringUtils {

    public static final String EMPTY = "";

    private StringUtils() {}

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
}
