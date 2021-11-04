package lotto.domain;

import lotto.exception.LottoNumberRangeException;

import static lotto.common.LottoConst.MAX_NUMBER;
import static lotto.common.LottoConst.MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(final int number) {
        validation(number);
        this.number = number;
    }

    private void validation(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoNumberRangeException();
        }
    }

    public int getNumber() {
        return number;
    }
}
