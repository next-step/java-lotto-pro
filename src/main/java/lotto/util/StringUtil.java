package lotto.util;

public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }

        return false;
    }
}
