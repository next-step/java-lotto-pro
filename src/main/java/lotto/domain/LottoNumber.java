package lotto.domain;

import lotto.exception.LottoNumberRangeException;

import static lotto.common.LottoConst.MAX_NUMBER;
import static lotto.common.LottoConst.MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validation(number);
        this.number = number;
    }

    private void validation(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoNumberRangeException();
        }
    }
}
