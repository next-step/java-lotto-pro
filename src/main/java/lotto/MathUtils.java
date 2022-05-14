package lotto;

public class MathUtils {

    private MathUtils() {
        throw new UnsupportedOperationException();
    }

    public static double round(double value, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("음수는 지원하지 않습니다");
        }
        double offset = Math.pow(10.0, index);

        return Math.round(value * offset) / offset;
    }
}
