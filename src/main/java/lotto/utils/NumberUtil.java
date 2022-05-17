package lotto.utils;

public class NumberUtil {

    private NumberUtil() {
    }

    public static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
