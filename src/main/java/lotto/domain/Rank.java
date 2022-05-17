package lotto.domain;

import lotto.domain.calculator.RankCalculator;

public enum Rank {
    FIRST(6, 2_000_000_000), SECOND(5, 30_000_000), THIRD(5, 1_500_000), FOURTH(4, 50_000), FIFTH(3,
        5_000), MISS(0, 0);

    private final int countOfMatch;
    private final int winningsMoney;

    Rank(int countOfMatch, int winningsMoney) {
        this.countOfMatch = countOfMatch;
        this.winningsMoney = winningsMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningsMoney() {
        return winningsMoney;
    }


    public static Rank valueOf(int countOfMatch, RankCalculator rankCalculator) {
        return rankCalculator.calculator(countOfMatch);
    }
}
