package calculator.utils;

public class StringParser {
    private static final String UNAVAILABLE_TO_PARSE_AS_INTEGER = "[ERROR] 숫자 이외의 값 또는 음수는 허용하지 않습니다.";
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";

    private StringParser() {
        throw new AssertionError();
    }

    public static Integer parseAsInteger(String string) {
        if (!string.matches(POSITIVE_NUMBER_REGEX)) {
            throw new RuntimeException(UNAVAILABLE_TO_PARSE_AS_INTEGER);
        }

        return Integer.parseInt(string);
    }
}
