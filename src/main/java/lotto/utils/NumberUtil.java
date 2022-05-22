package lotto.utils;

public class NumberUtil {
    private final static String ERROR_NUMBER_MESSAGE = "[ERROR] 숫자만 입력해주세요.";

    public static int parseStringToInt(String numberText) {
        try {
            return Integer.parseInt(numberText.trim());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
    }

    public static double intToDouble(int number) {
        return number;
    }
}
