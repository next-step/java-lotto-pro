package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == Rank.MISS.countOfMatch) {
            return Rank.MISS;
        }
        if (isThirdCondition(countOfMatch, matchBonus)) {
            return Rank.THIRD;
        }

        Rank[] ranks = values();
        return Arrays.stream(ranks)
            .filter(rank -> countOfMatch == rank.countOfMatch)
            .findFirst()
            .orElse(Rank.MISS);
    }

    private static boolean isThirdCondition(int countOfMatch, boolean matchBonus) {
        return countOfMatch == Rank.THIRD.countOfMatch && !matchBonus;
    }

    public boolean isFirst() {
        return this == FIRST;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public boolean isThird() {
        return this == THIRD;
    }

    public boolean isFourth() {
        return this == FOURTH;
    }

    public boolean isFifth() {
        return this == FIFTH;
    }
}
