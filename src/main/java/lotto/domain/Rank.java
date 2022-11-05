package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    public static final int RANK_BONUS_COUNT = 5;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank match(Lotto lotto, Lotto winLotto) {
        int matchCount = lotto.countMatchNumber(winLotto);
        return findRankNoBonus(matchCount);
    }

    private static Rank findRankNoBonus(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.getCountOfMatch() == matchCount)
                .filter(r -> !r.equals(SECOND))
                .findAny()
                .orElse(MISS);
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (matchBonus) {
            return findRankBonus(countOfMatch);
        }
        return findRankNoBonus(countOfMatch);
    }

    private static Rank findRankBonus(int countOfMatch) {
        if (countOfMatch == RANK_BONUS_COUNT) {
            return SECOND;
        }
        return findRankNoBonus(countOfMatch);
    }

}
