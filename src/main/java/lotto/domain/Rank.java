package lotto.domain;

import lotto.startegy.MatchStrategy;

import java.util.function.Function;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6,2000000000, count -> (count == 6)),
    SECOND(5, 1500000, count -> (count == 5)),
    THIRD(4, 0, count -> (count == 4)),
    FOURTH(3, 0, count -> (count == 3)),
    NONE(2, 0, count -> (count <= 2));

    private int matchCount;
    private int prizeMoney;
    private MatchStrategy expression;

    Rank(int matchCount, int prizeMoney, MatchStrategy expression) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.expression = expression;
    }

    public static Rank of(int answerCount) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.expression.isMatch(answerCount))
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public MatchStrategy getExpression() {
        return expression;
    }
}
