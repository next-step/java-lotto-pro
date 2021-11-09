package util;

public final class Numbers {

    private Numbers() {
    }

    public static boolean isNegative(final Number number) {
        return number.intValue() < 0;
    }

    public static int parseInt(final String text) {
        return Integer.parseInt(text);
    }
}
