package lotto.utils;

import java.util.List;

public class ValidationUtils {

    private static final String NUMBER_FORMAT_REGEX = "^[0-9|,]+$";

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumberFormat(String str) {
        return str.matches(NUMBER_FORMAT_REGEX);
    }

    public static boolean isArrayEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean isArrayLengthOver(List<?> list, int len) {
        return list != null && list.size() > len;
    }

    public static boolean isArrayLengthUnder(List<?> list, int len) {
        return list != null && list.size() < len;
    }

}
