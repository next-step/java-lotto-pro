package lotto.domain;

import static calculator.constants.LottoNumberConstants.*;

import calculator.constants.LottoErrorMessage;

public class LottoNumber {

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validateLottoNumber(number);
        return new LottoNumber(number);
    }

    private static void validateLottoNumber(int number) {
        if (LOTTO_NUMBER_MIN <= number && LOTTO_NUMBER_MAX >= number) {
            return;
        }
        throw new IllegalArgumentException(
            String.format(LottoErrorMessage.INVALID_LOTTO_NUMBER, number));
    }

    public int getNumber() {
        return this.number;
    }
}
