package util;

public class StringToIntegerConverter {
    private static final String CANNOT_CONVERT_NUMBER_EXCEPTION_MESSAGE = "유효하지 않은 입력값입니다.";
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
