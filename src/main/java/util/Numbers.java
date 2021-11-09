package util;

public final class Numbers {

    private Numbers() {
    }

    public static boolean isNegative(final Number number) {
        return number.intValue() < 0;
    }
}
