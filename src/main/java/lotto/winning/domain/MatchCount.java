package lotto.winning.domain;

import lotto.lotto.domain.Lotto;

import java.util.List;

public class MatchCount {

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;
    private Count threeMatchCount;
    private Count fourMatchCount;
    private Count fiveMatchCount;
    private Count sixMatchCount;

    public MatchCount(List<Lotto> lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public TotalWinningMoney generate() {
        for (Lotto lotto : this.lottos) {
            if (this.winningNumber.matchCounts(lotto) == 3) {
                this.threeMatchCount.plus();
            } else if (this.winningNumber.matchCounts(lotto) == 4) {
                this.fourMatchCount.plus();
            } else if (this.winningNumber.matchCounts(lotto) == 5) {
                this.fiveMatchCount.plus();
            } else if (this.winningNumber.matchCounts(lotto) == 6) {
                this.sixMatchCount.plus();
            }
        }
        return new TotalWinningMoney(threeMatchCount, fourMatchCount, fiveMatchCount, sixMatchCount);
    }
}
