package lotto.model;

import lotto.view.ErrorMessage;

import java.util.Objects;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;
    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        validBonusExist(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validBonusExist(LottoNumber bonusNumber) {
        if(lotto.isBounsNumber(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_EXIST);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
