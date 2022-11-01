package lotto.domain.matcher.count;

import lotto.domain.result.LottoResult;

public class MatchCount {

    private int matchCount;
    private boolean matchBonus;

    public MatchCount(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    @Override
    public boolean equals(Object matchCount) {
        int resultMatchCount = this.matchCount;
        if (matchBonus) {
            resultMatchCount = this.matchCount - 1;
        }
        return resultMatchCount == (int) matchCount;
    }

    public LottoResult isMatchBonus(LottoResult lottoResult) {
        if (lottoResult == LottoResult.FIVE) {
            return !matchBonus ? LottoResult.FIVE : LottoResult.MISS;
        }
        if (lottoResult == LottoResult.FIVE_BONUS) {
            return matchBonus ? LottoResult.FIVE_BONUS : LottoResult.MISS;
        }
        return lottoResult;
    }
}
