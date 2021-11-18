package util;

public final class NumberUtils {

    public static final int ZERO = 0;

    private NumberUtils() {
    }

    public static boolean isZero(final Number number) {
        return number.longValue() == ZERO;
    }

    public static boolean isNegative(final Number number) {
        return number.longValue() < ZERO;
    }

    public static int parseInt(final String text) {
        return Integer.parseInt(text);
    }
}
