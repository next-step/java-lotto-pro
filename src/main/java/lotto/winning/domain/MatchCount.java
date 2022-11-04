package lotto.winning.domain;

import lotto.lotto.domain.Lotto;

import java.util.List;

public class MatchCount {

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int sixMatchCount;

    public MatchCount(List<Lotto> lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public void generate() {
        for (Lotto lotto : this.lottos) {
            if (this.winningNumber.matchCounts(lotto) == 3) {
                threeMatchCount++;
            } else if (this.winningNumber.matchCounts(lotto) == 4) {
                fourMatchCount++;
            } else if (this.winningNumber.matchCounts(lotto) == 5) {
                fiveMatchCount++;
            } else if (this.winningNumber.matchCounts(lotto) == 6) {
                sixMatchCount++;
            }
        }
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }
}
