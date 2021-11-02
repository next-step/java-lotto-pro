package step2;

public class SplitNumber {
    public static final String NOT_POSITIVE_NUMBER_MESSAGE = "입력 값은 양수만 가능합니다.";

    public static int valueOf(String value) {
        valid(value);
        return Integer.parseInt(value);
    }

    private static void valid(String value) {
        if (!isNumber(value) || Integer.parseInt(value) < 0) {
            throw new RuntimeException(NOT_POSITIVE_NUMBER_MESSAGE);
        }
    }

    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
