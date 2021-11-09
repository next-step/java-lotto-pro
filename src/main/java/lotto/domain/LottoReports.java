package lotto.domain;

import java.util.List;

public class LottoReports {
    private final LottoMoney lottoMoney;
    private final LottoRanksCount lottoRanksCount;

    public LottoReports(List<Rank> lottoRanks, LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
        this.lottoRanksCount = new LottoRanksCount(lottoRanks);
    }

    public long getRankCount(Rank rank) {
        return lottoRanksCount.getRankCount(rank);
    }

    public double getProfitRatio() {
        long winningAmount = sumWinningAmount();
        return lottoMoney.calculateProfitRatio(winningAmount);
    }

    private long sumWinningAmount() {
        return getRankCount(Rank.FIRST) * Rank.FIRST.getWinningMoney()
            + getRankCount(Rank.SECOND) * Rank.SECOND.getWinningMoney()
            + getRankCount(Rank.THIRD) * Rank.THIRD.getWinningMoney()
            + getRankCount(Rank.FOURTH) * Rank.FOURTH.getWinningMoney()
            + getRankCount(Rank.FIFTH) * Rank.FIFTH.getWinningMoney();
    }
}
