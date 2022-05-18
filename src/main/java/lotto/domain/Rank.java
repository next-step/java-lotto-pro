package lotto.domain;

import java.util.Arrays;

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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank rank =  Arrays.stream(Rank.values()).filter(x -> x.getCountOfMatch() == countOfMatch).findFirst()
            .orElse(Rank.MISS);

        return bonusNumberCheck(rank, matchBonus);
    }

    private static Rank bonusNumberCheck(Rank rank, boolean matchBonus) {
        if (rank.isCountOfMatchFive()) {
            return bonusRankCheck(matchBonus);
        }

        return rank;
    }

    private boolean isCountOfMatchFive() {
        return this.countOfMatch == 5;
    }

    private static Rank bonusRankCheck(boolean matchBonus) {
        if (matchBonus) {
            return Rank.SECOND;
        }

        return Rank.THIRD;
    }

    public boolean isNotMiss() {
        return this != MISS;
    }
}
