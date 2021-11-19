package lotto.domain;

import lotto.consts.LottoNumberConst;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningLotto) {
        validationCheck(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private void validationCheck(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < LottoNumberConst.START_NUMBER || bonusNumber > LottoNumberConst.END_NUMBER) {
            throw new IllegalArgumentException();
        }

        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
