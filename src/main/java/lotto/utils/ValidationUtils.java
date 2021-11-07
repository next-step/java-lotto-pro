package lotto.utils;

import lotto.domain.Money;

public class ValidationUtils {
    private static final String REGEX_NUMBER = "[0-9]+";

    private ValidationUtils() {
    }

    public static boolean isNumber(String number) {
        return number.matches(REGEX_NUMBER);
    }

    public static boolean upperThanMinPrice(String number) {
        return Integer.parseInt(number) >= Money.LOTTO_BUY_PRICE;
    }

}
