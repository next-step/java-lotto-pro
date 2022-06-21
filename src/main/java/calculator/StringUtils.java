package calculator;

public class StringUtils {
    private static final String INVALID_STRING_WAS_ENTERED = "잘못된 문자열이 입력되었습니다.";

    private StringUtils() {
    }

    public static String readString(String input) {
        if (isNull(input) || isEmpty(input)) {
            return "0";
        }
        if (isInvalid(input)) {
            throw new IllegalArgumentException(INVALID_STRING_WAS_ENTERED);
        }
        return input;
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isEmpty(String input) {
        return input.trim()
                    .isEmpty();
    }

    private static boolean isInvalid(String input) {
        return StringRegex.isInvalid(input);
    }
}
