package step3;

public class ValidationUtils {
    private static final String INPUT_INT_EXCEPTION = "입력값은 숫자여야 합니다.";
    private static final String INPUT_COUNT_EXCEPTION_MESSAGE = "입력값이 구입액에 비해 큽니다.";
    private static final String INPUT_PAYMENT_EXCEPTION_MESSAGE = "입력값은 0 이상이어야 합니다.";

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INPUT_INT_EXCEPTION);
        }
    }

    public static void validManualCount(int manualCount, int lottoCount) {
        if (manualCount > lottoCount || isNegative(manualCount)) {
            throw new IllegalArgumentException(INPUT_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public static boolean isNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(INPUT_PAYMENT_EXCEPTION_MESSAGE);
        }
        return false;
    }
}
