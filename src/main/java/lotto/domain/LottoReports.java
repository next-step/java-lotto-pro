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

    public long countOfFirst() {
        return lottoRanks.stream()
            .filter(Rank::isFirst)
            .count();
    }

    public long countOfSecond() {
        return lottoRanks.stream()
            .filter(Rank::isSecond)
            .count();
    }

    public long countOfThird() {
        return lottoRanks.stream()
            .filter(Rank::isThird)
            .count();
    }

    public long countOfFifty() {
        return lottoRanks.stream()
            .filter(Rank::isFifth)
            .count();
    }

    public double profitRatio() {
        long winningAmount = sumWinningAmount();
        return lottoMoney.profitRatio(winningAmount);
    }

    private long sumWinningAmount() {
        return countOfFirst() * Rank.FIRST.getWinningMoney()
            + countOfSecond() * Rank.SECOND.getWinningMoney()
            + countOfThird() * Rank.THIRD.getWinningMoney()
            + countOfFifty() * Rank.FIFTH.getWinningMoney();
    }
}
