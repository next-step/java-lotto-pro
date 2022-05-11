package calculator.util;

public class StringUtils {

    private StringUtils() {

    }

    public static boolean isEmptyString(String string) {
        return string == null || string.isEmpty();
    }
}
