package step1.utils;

public class StringUtil {
    public static String substring(final String target) {
        return target.substring(target.indexOf("(") + 1, target.indexOf(")"));
    }
}
