package study;

public class StringParser {
    private static final String ERROR_NOT_ALLOW_VALUE_MESSAGE = "[ERROR] 허용하지 않은 값 입니다.";

    public static int stringToIntValue(String text) {
        int number = Integer.parseInt(text);
        checkThrowExceptionNumber(number);
        return number;
    }

    private static void checkThrowExceptionNumber(int number) {
        if (isNegative(number))
            throw new IllegalArgumentException(ERROR_NOT_ALLOW_VALUE_MESSAGE);
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }
}
