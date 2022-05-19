package lotto.utils;

public class StringUtil {
    private StringUtil() {}

    public static final String EMPTY = "";

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static String trim(String string) {
        return string.replaceAll("\\s+", "");
    }
}
