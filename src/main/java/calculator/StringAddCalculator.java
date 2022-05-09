package calculator;

public class StringAddCalculator {
    public static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바르지 않는 숫자 형식입니다.";
    public static final String INVALID_NUMBER_RANGE_MESSAGE = "올바르지 않는 숫자 범위입니다. 가능한 범위는 0부터 2147483647입니다.";
    private static final String NUMBER_FORMAT_REGEX = "^(0|[1-9]+[0-9]*)$";

    private StringAddCalculator() {
    }

    public static int input(String number) {
        if (isNotValidNumber(number)) {
            return 0;
        }
        return parsePositiveOrZeroNumber(number);
    }

    private static int parsePositiveOrZeroNumber(String number) {
        validatePositiveOrZeroNumber(number);
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    private static void validatePositiveOrZeroNumber(String number) {
        if (!number.matches(NUMBER_FORMAT_REGEX)) {
            throw new RuntimeException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static boolean isNotValidNumber(String number) {
        return isNull(number) || isEmpty(number);
    }

    private static boolean isEmpty(String number) {
        return number.trim().isEmpty();
    }

    private static boolean isNull(String number) {
        return number == null;
    }
}
