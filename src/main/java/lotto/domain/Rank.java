package lotto.domain;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;
import static lotto.domain.MatchBonus.*;

public enum Rank {
    FIRST(MATCH_COUNT_BY_MATCH_BONUS_FALSE.get(6), 2_000_000_000),
    SECOND(MATCH_COUNT_BY_MATCH_BONUS_TRUE.get(5), 30_000_000),
    THIRD(MATCH_COUNT_BY_MATCH_BONUS_FALSE.get(5), 1_500_000),
    FOURTH(MATCH_COUNT_BY_MATCH_BONUS_FALSE.get(4), 50_000),
    FIFTH(MATCH_COUNT_BY_MATCH_BONUS_FALSE.get(3), 5_000),
    MISS(MATCH_COUNT_MISS, 0);

    private MatchBonus matchBonus;
    private final int winningMoney;
    private final static Map<MatchBonus, Rank> RANK_BY_MATCH_COUNT =
            Arrays.stream(values())
                    .filter(rank -> rank != Rank.MISS)
                    .collect(collectingAndThen(
                            toMap(Rank::getMatchBonus, Function.identity()),
                            Collections::unmodifiableMap));

    Rank(MatchBonus matchBonus, int winningMoney) {
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public MatchBonus getMatchBonus() {
        return matchBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return RANK_BY_MATCH_COUNT.getOrDefault(MatchBonus.of(countOfMatch, matchBonus),MISS);
    }

    public static List<Rank> getAllRanksExceptMiss() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public static List<Rank> getAllRanks() {
        return Arrays.asList(MISS, FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public static int getCountOfMatch(Rank rank) {
        return rank.getMatchBonus().getCountOfMatch();
    }
}
