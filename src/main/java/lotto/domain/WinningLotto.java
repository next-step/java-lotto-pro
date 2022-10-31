package lotto.domain;

import common.constant.ErrorCode;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        validateBonusLottoNumber(winningLotto, bonusLottoNumber);
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validateBonusLottoNumber(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        if(winningLotto.isMatchLottoNumber(bonusLottoNumber)) {
            throw new IllegalArgumentException(ErrorCode.보너스_볼은_당첨_로또의_각_숫자와_중복_불가.getErrorMessage());
        }
    }

    public int findLottoMatchCount(Lotto lotto) {
        return lotto.findLottoMatchCount(winningLotto);
    }

    public boolean isMatchBonusLottoNumber(Lotto lotto) {
        return lotto.isMatchLottoNumber(bonusLottoNumber);
    }
}
