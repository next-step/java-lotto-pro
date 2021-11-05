package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);
    }

    public static List<Rank> excludedMissList() {
        return Arrays.stream(values())
                .filter(Rank::isNotMiss)
                .collect(Collectors.toList());
    }

    public boolean isNotMiss() {
        return !this.equals(Rank.MISS);
    }

    public int calculateRevenue(int count) {
        return winningMoney * count;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
