package lotto;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);


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
        Rank[] ranks = values();
        Rank rank = null;
        for (Rank tempRank : ranks) {
            rank = findCountOfMatch(tempRank, countOfMatch) == true ? tempRank : rank;
        }

        return rank;
    }

    private static boolean findCountOfMatch(Rank rank, int countOfMatch) {
        if (rank.countOfMatch == countOfMatch) {
            return true;
        }
        return false;
    }
}
