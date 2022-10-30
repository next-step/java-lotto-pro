package lotto.util;

public class IntUtil {
    public static int parseInt(String str) {
        int result = 0;

        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        }

        return result;
    }
}
