package lotto.domain;

import lotto.startegy.MatchStrategy;

import java.math.BigDecimal;
import java.util.stream.Stream;

public enum Rank {
    NONE(new WinningCondition(2, BigDecimal.valueOf(0)), (count, match) -> count <= 2),
    FIVE(new WinningCondition(3, BigDecimal.valueOf(5_000)), (count, match) -> count == 3),
    FOUR(new WinningCondition(4, BigDecimal.valueOf(50_000)), (count, match) -> count == 4),
    THIRD(new WinningCondition(5, BigDecimal.valueOf(1_500_000)), (count, match) -> (count == 5 && !match)),
    SECOND(new WinningCondition(5, BigDecimal.valueOf(30_000_000)), (count, match) -> (count == 5 && match)),
    FIRST(new WinningCondition(6, BigDecimal.valueOf(2_000_000_000)), (count, match) -> count == 6);

    private final WinningCondition winningCondition;
    private final MatchStrategy expression;

    Rank(WinningCondition winningCondition, MatchStrategy expression) {
        this.winningCondition = winningCondition;
        this.expression = expression;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.expression.isMatch(matchCount, matchBonus))
                .findFirst()
                .orElse(NONE);
    }

    public boolean isRankMatch(Rank rank) {
        return this.equals(rank);
    }

    public BigDecimal getPrizeMoney() {
        return winningCondition.getPrizeMoney();
    }

    public int getMatchCount() {
        return winningCondition.getCount();
    }
}
