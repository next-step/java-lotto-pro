package lotto.utils;

public class NumberUtil {
    private final static String ERROR_INVALID_LOTTO_NUMBER_MESSAGE = "";

    public static int parseStringToInt(String numberText) {
        try {
            return Integer.parseInt(numberText);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER_MESSAGE);
        }
    }

    public static double intToDouble(int number) {
        return number;
    }
}
