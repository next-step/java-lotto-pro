package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private boolean checkBonus;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.checkBonus = false;
    }

    private Rank(int countOfMatch, int winningMoney, boolean checkBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.checkBonus = checkBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean getCheckBonus() {
        return checkBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank match(Lotto lotto, Lotto winLotto) {
        int matchCount = lotto.countMatchNumber(winLotto);
        return valueOf(matchCount);
    }

    /*private static Rank findRankNoBonus(int matchCount) {
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
    }*/

    public static Rank valueOf(int countOfMath) {
        return valueOf(countOfMath, false);
    }

    public static Rank valueOf(int countOfMatch, boolean checkBonus) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.getCountOfMatch() == countOfMatch)
                .filter(r -> r.isMatch(countOfMatch, checkBonus))
                .findAny()
                .orElse(MISS);
    }

    private boolean isMatch(int countOfMatch, boolean checkBonus) {
        return this.countOfMatch == countOfMatch && this.checkBonus == checkBonus;
    }

}
