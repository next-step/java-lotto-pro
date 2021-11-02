package study.utils;

public class StringUtils {

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
}
