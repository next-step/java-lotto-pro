package lotto.utils;

import java.util.Arrays;
import java.util.List;

public final class StringUtil {

    private StringUtil() {
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isInvalidFormat(String str, String format) {
        return !str.matches(format);
    }

    public static List<String> splitToList(String str, String delimiter) {
        if (str == null || delimiter == null) {
            throw new IllegalArgumentException("문자열이나 구분자가 존재하지 않습니다.");
        }
        return Arrays.asList(str.split(delimiter));
    }
}
