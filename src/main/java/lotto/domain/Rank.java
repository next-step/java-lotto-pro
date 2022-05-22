package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int winningAmount;

    Rank(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

    public static Rank valueOf(int matchCount, boolean bonusNumber) {
        if (matchCount==5 && bonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(lottoStatistic -> lottoStatistic.matchCount == matchCount)
                .findFirst()
                .orElse(Rank.MISS);
    }

    public double calculatorProfit(int n) {
        return this.winningAmount * n;
    }

    public String toString(Integer n) {
        if (n == null) n = 0;
        if (this.winningAmount == SECOND.winningAmount) {
            return this.matchCount + "개 일치, 보너스 볼 일치("+ this.winningAmount + ")- " + n +"개";
        }
        return this.matchCount + "개 일치 (" + this.winningAmount + ")- " + n +"개";
    }
}
