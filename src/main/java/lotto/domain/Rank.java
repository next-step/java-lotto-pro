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

    private static final int RANK_BONUS_COUNT = 5;

    Rank(int countOfMatch, int winningMoney) {
        this(countOfMatch, winningMoney, false);
    }

    Rank(int countOfMatch, int winningMoney, boolean checkBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.checkBonus = checkBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean checkBonus) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.isMatch(countOfMatch, checkBonus))
                .findAny()
                .orElse(MISS);
    }

    private boolean isMatch(int countOfMatch, boolean checkBonus) {
        if (countOfMatch != RANK_BONUS_COUNT)
            return this.countOfMatch == countOfMatch;
        return this.countOfMatch == countOfMatch && this.checkBonus == checkBonus;
    }

}
