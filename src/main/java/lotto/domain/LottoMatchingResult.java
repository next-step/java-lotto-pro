package lotto.domain;

import lotto.enums.LottoRank;

public class LottoMatchingResult {
    private int countOfMatch;
    private boolean isBonusMatched;

    public LottoMatchingResult() {
        countOfMatch = 0;
        isBonusMatched = false;
    }

    public LottoMatchingResult(int countOfMatch, boolean isBonusMatched) {
        this.countOfMatch = countOfMatch;
        this.isBonusMatched = isBonusMatched;
    }

    public void addCountOfMatch() {
        this.countOfMatch += 1;
    }

    public void confirmBonusMatched() {
        this.isBonusMatched = true;
    }

    public LottoRank convertToLottoRank() {
        return LottoRank.findMatchedLottoRank(this.countOfMatch, this.isBonusMatched);
    }
}
