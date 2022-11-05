package step3;

public class Utils {
    private static final String INPUT_INT_EXCEPTION = "입력값은 숫자여야 합니다.";
    private static final String INPUT_PAYMENT_EXCEPTION_MESSAGE = "입력값은 0 이상이어야 합니다.";

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INPUT_INT_EXCEPTION);
        }
    }

    public static boolean isNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(INPUT_PAYMENT_EXCEPTION_MESSAGE);
        }
        return false;
    }
}
