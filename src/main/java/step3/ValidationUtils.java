package step3;

public class ValidationUtils {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String LOTTO_RANGE_EXCEPTION = "로또번호는 1부터 45까지의 숫자여야 합니다.";
    private static final String INPUT_COUNT_EXCEPTION_MESSAGE = "입력값이 구입액에 비해 큽니다.";
    private static final String INPUT_PAYMENT_EXCEPTION_MESSAGE = "입력값은 0 이상이어야 합니다.";

    public static int parseInt(String input) {
        try {
            int parseNumber = Integer.parseInt(input);
            validLottoNumber(parseNumber);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION);
        }
    }

    private static void validLottoNumber(int parseNumber) {
        if (parseNumber < LOTTO_MIN_NUMBER || parseNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION);
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
