package lotto.domain;

import lotto.startegy.MatchStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public enum Rank {
    NONE(2, 0, (count, match) -> count <= 2),
    FIVE(3, 5000, (count, match) -> count == 3),
    FOURTH(3, 5000, (count, match) -> count == 3),
    THIRD(4, 50_000, (count, match) -> count == 4),
    SECOND(5, 1_500_000, (count, match) -> (count == 5 && !match)),
    SECOND_BONUS(5, 30_000_000, (count, match) -> (count == 5 && match)),
    FIRST(6, 2_000_000_000, (count, match) -> count == 6);

    private int matchCount;
    private int prizeMoney;
    private MatchStrategy expression;

    Rank(int matchCount, int prizeMoney, MatchStrategy expression) {
        this.matchCount = matchCount;
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

    @Override
    public String toString() {
        return matchCount + "개 일치 " + (this.equals(Rank.SECOND_BONUS) ? ", 보너스 볼 일치" : "")
                + "(" + prizeMoney + "원) - ";
    }
}
