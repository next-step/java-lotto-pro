package lotto.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(1, new MatchCount(6, false), 2_000_000_000),
    SECOND(2, new MatchCount(5, true), 30_000_000),
    THIRD(3, new MatchCount(5, false), 1_500_000),
    FOURTH(4, new MatchCount(4, false), 50_000),
    FIFTH(5, new MatchCount(3, false), 5_000),
    MISS(6, new MatchCount(0, false), 0);

    private static final Map<MatchCount, Rank> matchCountToRank = Stream.of(values())
            .collect(Collectors.toMap(Rank::getMatchCount, Function.identity()));

    private final int rankingNumber;
    private final int winningMoney;
    private final MatchCount matchCount;

    Rank(int rankingNumber, MatchCount matchCount, int winningMoney) {
        this.rankingNumber = rankingNumber;
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public MatchCount getMatchCount() {
        return matchCount;
    }

    public int getRankingNumber() {
        return rankingNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(MatchCount matchCount) {
        return matchCountToRank.getOrDefault(matchCount, Rank.MISS);
    }
}
