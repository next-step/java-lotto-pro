package study.util;

public class NumberUtil {

    public static final int ZERO = 0;
    public static final int ONE = 1;

    public static int convertStrToInt(String str) {
        try {
            int num = Integer.parseInt(str);
            if(num < ZERO) {
                throw new RuntimeException("[ERROR] The given string cannot contain negative numbers.");
            }
            return num;
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("[ERROR] The given string contains characters that cannot be converted to numbers.");
        }
    }
}
