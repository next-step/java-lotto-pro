package study.util;

public class StringUtil {

    private static final int INSEPARABLE_NUM = 1;

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotSplit(String str) {
        return str.length() <= INSEPARABLE_NUM;
    }
}
