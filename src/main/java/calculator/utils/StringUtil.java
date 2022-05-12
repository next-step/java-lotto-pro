package calculator.utils;

public class StringUtil {
    private StringUtil() {
        throw new AssertionError();
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
