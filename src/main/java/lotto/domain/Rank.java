package lotto.domain;

import lotto.domain.startegy.winningstrategy.WinningStrategy;

import java.util.stream.Stream;

public enum Rank {

    MISS(0, 3, (matchingCount, isBonus) -> matchingCount < 3),
    FIFTH(5_000, 3, (matchingCount, isBonus) -> matchingCount == 3),
    FOURTH(50_000, 4, (matchingCount, isBonus) -> matchingCount == 4),
    THIRD(1_500_000, 5, (matchingCount, isBonus) -> matchingCount == 5 && !isBonus),
    SECOND(30_000_000, 5, (matchingCount, isBonus) -> matchingCount == 5 && isBonus),
    FIRST(2_000_000_000, 6, (matchingCount, isBonus) -> matchingCount == 6);

    private final int winningMoney;
    private final int countOfMatch;
    private final WinningStrategy winningStrategy;

    Rank(final int winningMoney, final int countOfMatch, final WinningStrategy winningStrategy) {
        this.winningMoney = winningMoney;
        this.countOfMatch = countOfMatch;
        this.winningStrategy = winningStrategy;
    }

    public static Rank findRank(final int matchingCount, final boolean isBonus) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.winningStrategy.winnable(matchingCount, isBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int totalWinningMoney(final int hitCount) {
        return this.winningMoney * hitCount;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

}
