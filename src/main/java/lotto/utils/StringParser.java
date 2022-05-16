package lotto.utils;

public class StringParser {
    private static final String UNAVAILABLE_TO_PARSE_AS_INTEGER = "[ERROR] 숫자 이외의 값 또는 음수는 허용하지 않습니다.";
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";

    private StringParser() {}

    public static Integer parseAsInteger(String string) {
        String trimString = StringUtil.trim(string);
        if (!trimString.matches(POSITIVE_NUMBER_REGEX) || StringUtil.isNullOrEmpty(trimString)) {
            throw new IllegalArgumentException(UNAVAILABLE_TO_PARSE_AS_INTEGER);
        }

        return Integer.parseInt(trimString);
    }
}
