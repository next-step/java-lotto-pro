package lotto.domain;

import lotto.enums.LottoRank;

public class LottoMatchingResult {
    private final int countOfMatch;
    private final boolean isBonusMatched;

    public LottoMatchingResult(int countOfMatch, boolean isBonusMatched) {
        this.countOfMatch = countOfMatch;
        this.isBonusMatched = isBonusMatched;
    }

    public LottoRank convertToLottoRank() {
        return LottoRank.findMatchedLottoRank(this.countOfMatch, this.isBonusMatched);
    }
}
