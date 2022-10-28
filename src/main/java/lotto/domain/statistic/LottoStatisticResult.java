package lotto.domain.statistic;

import lotto.domain.money.Money;
import lotto.domain.win.WinRanking;

public class LottoStatisticResult {
    private final WinRanking ranking;
    private final int matchCount;

    private LottoStatisticResult(WinRanking ranking, int matchCount) {
        this.ranking = ranking;
        this.matchCount = matchCount;
    }

    public static LottoStatisticResult of(WinRanking ranking, int matchCount) {
        return new LottoStatisticResult(ranking, matchCount);
    }

    public WinRanking getRanking() {
        return ranking;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money winningMoney() {
        return ranking.getWinningMoney().multiply(matchCount);
    }
}
