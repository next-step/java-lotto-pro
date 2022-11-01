package step3.domain.statistics;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {

    FIRST(new Match(6, false), 2_000_000_000),
    SECOND(new Match(5, true), 30_000_000),
    THIRD(new Match(5, false), 1_500_000),
    FOURTH(new Match(4, false), 50_000),
    FIFTH(new Match(3, false), 5_000),
    MISS(new Match(0, false), 0);

    private static final Map<Match, Rank> RANK_BY_MATCH =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Rank::getMatch, Function.identity())));

    private final Match match;
    private final int winningAmount;

    Rank(Match matchCount, int winningAmount) {
        this.match = matchCount;
        this.winningAmount = winningAmount;
    }

    public static Rank valueOf(Match match) {
        return RANK_BY_MATCH.get(match);
    }

    public static boolean isSecond(int count) {
        return SECOND.getMatch().getCount() == count;
    }

    public Match getMatch() {
        return match;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
