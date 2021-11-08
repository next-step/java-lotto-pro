package lotto.domain;

import lotto.constant.LottoRank;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank checkMatchRank(Lotto purchasedLotto) {
        int matchingNumberCount = purchasedLotto.getMatchingCountFromLotto(lotto);
        int matchingBonusNumberCount = purchasedLotto.getMatchingCountFromNumber(bonusNumber);

        return LottoRank.findRank(matchingNumberCount, matchingBonusNumberCount);
    }
}
