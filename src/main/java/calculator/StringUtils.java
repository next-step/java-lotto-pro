package calculator;

public class StringUtils {
    private static final String NON_NUMERIC_VALUE_IS_NOT_ALLOWED = "숫자 이외의 값은 허용되지 않습니다.";

    private StringUtils() {
    }

    public static String readString(String input) {
        if (isNull(input) || isEmpty(input)) {
            return "0";
        }
        if (isValid(input)) {
            throw new IllegalArgumentException(NON_NUMERIC_VALUE_IS_NOT_ALLOWED);
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

    private static boolean isValid(String input) {
        return StringRegex.isValid(input);
    }
}
