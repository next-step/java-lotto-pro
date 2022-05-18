package lotto.domain;

import static lotto.common.Messages.LOTTO_NUMBERS_SEPARATOR;
import static lotto.common.Messages.LOTTO_NUMBERS_SIZE;

public class LottoPassive {
    private static final int SIZE = 6;
    private static final String SEPARATOR = ",";

    private LottoPassive() {
    }

    public static String[] splitPassiveNumber(String passiveNumber) {
        validateSeparator(passiveNumber);
        validatePassiveNumbers(passiveNumber);

        return passiveNumber.split(SEPARATOR);
    }

    private static void validatePassiveNumbers(String text) {
        if (text.split(SEPARATOR).length < SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE);
        }
    }

    private static void validateSeparator(String text) {
        if (!text.contains(SEPARATOR)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SEPARATOR);
        }
    }
}
