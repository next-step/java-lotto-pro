package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        Rank rank = null;
        for (Rank value : Rank.values()) {
            rank = getRankCountOfMatch(countOfMatch, value);
        }
        return rank;
    }

    private static Rank getRankCountOfMatch(int countOfMatch, Rank value) {
        if (value.getCountOfMatch() == countOfMatch) {
            return value;
        }
        return null;
    }
}
