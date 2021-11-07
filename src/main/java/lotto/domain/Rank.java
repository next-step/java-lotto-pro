package lotto.domain;

import lotto.startegy.MatchStrategy;

import java.math.BigDecimal;
import java.util.stream.Stream;

public enum Rank {
    NONE(2, new Money(BigDecimal.valueOf(0)), (count, match) -> count <= 2),
    FIVE(3, new Money(BigDecimal.valueOf(5_000)), (count, match) -> count == 3),
    FOUR(4, new Money(BigDecimal.valueOf(50_000)), (count, match) -> count == 4),
    THIRD(5, new Money(BigDecimal.valueOf(1_500_000)), (count, match) -> (count == 5 && !match)),
    SECOND(5, new Money(BigDecimal.valueOf(30_000_000)), (count, match) -> (count == 5 && match)),
    FIRST(6, new Money(BigDecimal.valueOf(2_000_000_000)), (count, match) -> count == 6);

    private final int count;
    private final Money prizeMoney;
    private final MatchStrategy expression;

    Rank(int count, Money prizeMoney, MatchStrategy expression) {
        this.count = count;
        this.prizeMoney = prizeMoney;
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
        return prizeMoney.getMoney();
    }

    public int getMatchCount() {
        return count;
    }
}
