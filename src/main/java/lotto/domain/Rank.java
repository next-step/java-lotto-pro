package lotto.domain;

import lotto.domain.startegy.winningstrategy.WinningStrategy;

import java.util.stream.Stream;

public enum Rank {

    MISS(0, 0, (matchingCount) -> matchingCount < 3),
    FOURTH(5_000, 3, (matchingCount) -> matchingCount == 3),
    THIRD(50_000, 4, (matchingCount) -> matchingCount == 4),
    SECOND(1_500_000, 5, (matchingCount) -> matchingCount == 5),
    FIRST(2_000_000_000, 6, (matchingCount) -> matchingCount == 6);

    private final int winningMoney;
    private final int countOfMatch;
    private final WinningStrategy winningStrategy;

    Rank(final int winningMoney, final int countOfMatch, final WinningStrategy winningStrategy) {
        this.winningMoney = winningMoney;
        this.countOfMatch = countOfMatch;
        this.winningStrategy = winningStrategy;
    }

    public static Rank findRank(final int matchingCount) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.winningStrategy.winnable(matchingCount))
                .findFirst()
                .orElse(MISS);
    }

}
