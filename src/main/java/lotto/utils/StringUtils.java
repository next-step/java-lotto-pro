package lotto.utils;

public class StringUtils {

    public static final String IS_NOT_STRING_NUMBER = "문자열 숫자가 아닙니다.";

    private StringUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isNull(String str) {
        return str == null;
    }

    public static boolean isNumber(String str) {
        if (isNull(str)) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNotNumber(String str) {
        return !isNumber(str);
    }

    public static int toNumber(String str) {
        if (isNumber(str)) {
            return Integer.parseInt(str);
        }
        throw new IllegalArgumentException(String.format("%s: %s", IS_NOT_STRING_NUMBER, str));
    }
}
