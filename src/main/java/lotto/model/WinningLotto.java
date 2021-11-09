package lotto.model;

import lotto.view.ErrorMessage;

import java.util.Objects;

public class WinningLotto {
    private Lotto winLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winLotto, LottoNumber bonusNumber) {
        this.winLotto = winLotto;
        validBonusExist(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validBonusExist(LottoNumber bonusNumber) {
        if (winLotto.isBounsNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_EXIST);
        }
    }

    public Rank matchRank(Lotto lotto) {
        int result = this.winLotto.matchNumber(lotto);
        boolean matchBonus = lotto.isBounsNumber(bonusNumber);
        return Rank.valueOf(result, matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winLotto, that.winLotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winLotto, bonusNumber);
    }
}
