package lotto.auto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int SECOND_COUNT_OF_MATCH = 5;
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
    public static int getRank(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(Rank -> Rank.countOfMatch == numberOfMatch)
                .findFirst()
                .get()
                .winningMoney;
    }

    public static int getMoney(int countOfMatch, int cnt) {
        if (cnt > 0) {
            return (Arrays.stream(values())
                    .filter(Rank -> Rank.countOfMatch == countOfMatch)
                    .findFirst()
                    .get()
                    .winningMoney) * cnt;
        }
        return 0;
    }
    public static Rank valueOf(int countOfMatch) {
        Rank[] ranks = values();
        Rank rank = MISS;
        for (Rank tempRank : ranks) {
            rank = findCountOfMatch(tempRank, countOfMatch);
        }
        return rank;
    }

    private static Rank findCountOfMatch(Rank rank, int countOfMatch) {
        if (rank.countOfMatch == countOfMatch) {
            return rank;
        }
        return MISS;
    }
}
