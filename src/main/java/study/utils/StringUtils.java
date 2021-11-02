package study.utils;

public class StringUtils {

    public static final String IS_NOT_STRING_NUMBER = "문자열 숫자가 아닙니다.";
    public static final String IS_STRING_NEGATIVE_NUMBER = "문자열 음수입니다.";

    private StringUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * StringUtils.isBlank(null) -> true
     * StringUtils.isBlank("") -> true
     * StringUtils.isBlank(" ") -> true
     */
    public static boolean isBlank(String str) {
        return isEmpty(str) || str.equals(" ");
    }

    /**
     * StringUtils.isEmpty(null) -> true
     * StringUtils.isEmpty("") -> true
     * StringUtils.isEmpty(" ") -> false
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || str.isEmpty();
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

    public static int toNumber(String str) {
        if (isNumber(str)) {
            return Integer.parseInt(str);
        }
        throw new IllegalArgumentException(String.format("%s: %s", IS_NOT_STRING_NUMBER, str));
    }
}
