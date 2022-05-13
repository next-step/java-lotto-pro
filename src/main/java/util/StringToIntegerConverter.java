package util;

public class StringToIntegerConverter {
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }
}
