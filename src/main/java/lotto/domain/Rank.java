package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public static final int NEEDS_DISTINGUISH_COUNT = 5;
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

    public int getSumOfMoney(int count) {
        return winningMoney * count;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == NEEDS_DISTINGUISH_COUNT) {
            return computeBonusRank(matchBonus);
        }
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.countOfMatch == countOfMatch)
            .findFirst()
            .orElse(Rank.MISS);
    }

    private static Rank computeBonusRank(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", countOfMatch, winningMoney);
        }
        return String.format("%d개 일치 (%d원)", countOfMatch, winningMoney);
    }
}
