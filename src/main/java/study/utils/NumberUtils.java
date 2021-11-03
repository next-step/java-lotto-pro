package study.utils;

public class NumberUtils {

    public static final int ZERO = 0;

    private NumberUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isNegative(int number) {
        return number < ZERO;
    }
}
