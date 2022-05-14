package calculator;

public class NumberUtils {
    private static final int ZERO = 0;

    public static <T extends Number> boolean isLessThenZero(final T number) {
        return number.intValue() < ZERO;
    }
}
