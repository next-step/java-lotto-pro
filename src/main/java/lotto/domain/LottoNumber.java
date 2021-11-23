package lotto.domain;

import lotto.consts.LottoNumberConst;

public class LottoNumber {

    private final Integer number;

    public LottoNumber(Integer number) {
        checkNull(number);
        checkNumberRange(number);
        this.number = number;
    }

    private void checkNull(Integer number) {
        if (number == null) {
            throw new NullPointerException();
        }
    }

    private void checkNumberRange(Integer number) {
        if (number < LottoNumberConst.START_NUMBER || number > LottoNumberConst.END_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getNumber() {
        return number;
    }
}
