package lotto.domain;

import lotto.consts.LottoNumberConst;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        checkNumberRange(number);
        this.number = number;
    }

    public LottoNumber(int number, Lotto winningLotto) {
        checkNumberRange(number);
        checkDuplicate(number, winningLotto);
        this.number = number;
    }

    private void checkNumberRange(int number) {
        if (number < LottoNumberConst.START_NUMBER || number > LottoNumberConst.END_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(int number, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
