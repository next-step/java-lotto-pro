package lotto.utils;

public class NumberUtils {

    private NumberUtils() {
        throw new UnsupportedOperationException();
    }

    public static double roundDown(double decimal, int place) {
        double i = (place - 1);
        return Math.floor(decimal * Math.pow(10, i)) / Math.pow(10, i);
    }
}
