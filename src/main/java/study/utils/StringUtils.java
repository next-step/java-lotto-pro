package study.utils;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isEmpty(final String str) {
        return str == null || str.equals("");
    }
}
