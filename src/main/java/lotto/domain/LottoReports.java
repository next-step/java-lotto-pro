package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoReports {
    private final List<Rank> lottoRanks;
    private final LottoMoney lottoMoney;

    public LottoReports(List<Rank> lottoRanks, LottoMoney lottoMoney) {
        this.lottoRanks = Collections.unmodifiableList(lottoRanks);
        this.lottoMoney = lottoMoney;
    }

    public long getCountOfFirst() {
        return lottoRanks.stream()
            .filter(Rank::isFirst)
            .count();
    }

    public long getCountOfSecond() {
        return lottoRanks.stream()
            .filter(Rank::isSecond)
            .count();
    }

    public long getCountOfThird() {
        return lottoRanks.stream()
            .filter(Rank::isThird)
            .count();
    }

    public long getCountOfFourth() {
        return lottoRanks.stream()
            .filter(Rank::isFourth)
            .count();
    }

    public long getCountOfFifty() {
        return lottoRanks.stream()
            .filter(Rank::isFifth)
            .count();
    }

    public double getProfitRatio() {
        long winningAmount = sumWinningAmount();
        return lottoMoney.calculateProfitRatio(winningAmount);
    }

    private long sumWinningAmount() {
        return getCountOfFirst() * Rank.FIRST.getWinningMoney()
            + getCountOfSecond() * Rank.SECOND.getWinningMoney()
            + getCountOfThird() * Rank.THIRD.getWinningMoney()
            + getCountOfFourth() * Rank.FOURTH.getWinningMoney()
            + getCountOfFifty() * Rank.FIFTH.getWinningMoney();
    }
}
