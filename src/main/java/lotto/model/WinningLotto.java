package lotto.model;

import lotto.view.ErrorMessage;

import java.util.Objects;

public class WinningLotto {
    private final Lotto winLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winLotto, LottoNumber bonusNumber) {
        valid(winLotto, bonusNumber);
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    private void valid(Lotto lotto, LottoNumber bonusNumber) {
        validEmpty(lotto);
        validEmpty(bonusNumber);
        validBonusExist(lotto, bonusNumber);
    }

    private void validEmpty(Lotto lotto) {
        if (lotto == null) {
            throw new NullPointerException(ErrorMessage.LOTTO_NULL);
        }
    }

    private void validEmpty(LottoNumber bonusNumber) {
        if (bonusNumber == null) {
            throw new NullPointerException(ErrorMessage.LOTTO_NULL);
        }
    }

    private void validBonusExist(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isBounsNumber(bonusNumber)) {
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
