package lotto.domain;


import sun.management.StackTraceElementCompositeData;

import java.util.Arrays;

/**
 * packageName : lotto.domain
 * fileName : Rank
 * author : haedoang
 * date : 2021-11-05
 * description : Rank Enum
 */
public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;
    private boolean bonus;

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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == Rank.SECOND.getCountOfMatch()) return matchBonus ? SECOND : THIRD;
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);
    }
}
