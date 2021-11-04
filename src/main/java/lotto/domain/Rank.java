package lotto.domain;

import lotto.startegy.MatchStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public enum Rank {
    NONE(2, 0, count -> (count <= 2)),
    FOURTH(3, 5000, count -> (count == 3)),
    THIRD(4, 50000, count -> (count == 4)),
    SECOND(5, 1500000, count -> (count == 5)),
    FIRST(6, 2000000000, count -> (count == 6));

    private int matchCount;
    private int prizeMoney;
    private MatchStrategy expression;

    Rank(int matchCount, int prizeMoney, MatchStrategy expression) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.expression = expression;
    }

    public static Rank of(List<Number> matchNumbers, List<Number> lottoNumber) {
        int matchCount = getMatchCount(matchNumbers, lottoNumber);
        return Stream.of(Rank.values())
                .filter(rank -> rank.expression.isMatch(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    private static int getMatchCount(List<Number> matchNumbers, List<Number> lottoNumber) {
        int matchCount = 0;
        for (Number number : lottoNumber) {
            matchCount += Collections.frequency(matchNumbers, number);
        }
        return matchCount;
    }

    public boolean isType(Rank rank) {
        return this == rank;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
