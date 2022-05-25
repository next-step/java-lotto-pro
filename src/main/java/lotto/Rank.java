package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean bonusMatch;

    Rank(int countOfMatch, int winningMoney, boolean bonusMatch) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonusMatch = bonusMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private static Rank matchCountOfMatchAndBonus(int countOfMatch, boolean bonusMatch, Rank value) {
        if (countOfMatch == Rank.SECOND.getCountOfMatch() && bonusMatch) {
            return Rank.SECOND;
        }
        if (countOfMatch == Rank.THIRD.getCountOfMatch() && !bonusMatch) {
            return Rank.THIRD;
        }
        if (value.getCountOfMatch() == countOfMatch) {
            return value;
        }
        return null;
    }

    public static Rank matchedRank(int countOfMatch, boolean bonusMatch) {
        Rank rank = null;
        for (Rank value : Rank.values()) {
            Rank rankMatch = matchCountOfMatchAndBonus(countOfMatch, bonusMatch, value);
            rank = rankMatch != null ? rankMatch : rank;
        }
        return rank;
    }
}
