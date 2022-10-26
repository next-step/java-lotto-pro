package step2;

import java.util.Objects;

public class SplitNumber {

    private static final int ZERO = 0;
    private final int splitNumber;

    public SplitNumber(String splitNumber) {
        this.splitNumber = validation(splitNumber);
    }

    private static int validation(final String splitNumber) {
        checkNegative(splitNumber);
        return Integer.parseInt(splitNumber);
    }

    private static void checkNegative(final String splitNumber) {
        if (Integer.parseInt(splitNumber) < ZERO) {
            throw new IllegalArgumentException("덧셈에 음수는 허용되지 않습니다.");
        }
    }

    public int getSplitNumber() {
        return splitNumber;
    }
}
