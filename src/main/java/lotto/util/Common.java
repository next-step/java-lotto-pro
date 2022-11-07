package lotto.util;

public class Common {

    private static final String INVALID_NUMBER_MESSAGE = "입력값은 숫자값이어야 합니다.";

    public static int validateNumberType(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
        return num;
    }

}
