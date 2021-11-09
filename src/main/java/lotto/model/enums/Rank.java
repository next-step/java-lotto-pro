package lotto.model.enums;

import java.util.Arrays;
import java.util.List;

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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.getCountOfMatch() && matchBonus) {
            return SECOND;
        }
        if (countOfMatch == THIRD.getCountOfMatch() && !matchBonus) {
            return THIRD;
        }
        return Arrays.stream(values()).filter(rank -> rank.getCountOfMatch() == countOfMatch)
            .findFirst()
            .orElse(MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static List<Rank> getRanksHavingWinningMoney() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public boolean isSecond() {
        return this == SECOND;
    }
}
