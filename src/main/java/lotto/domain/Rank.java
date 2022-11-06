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
        Rank rank = RANK_BY_MATCH_COUNT.get(MatchBonus.of(countOfMatch, matchBonus));
        return rank == null ? MISS : rank;
    }

    public static List<Rank> getAllRanksExceptMiss() {
        return Arrays.asList(FIFTH,FOURTH,THIRD,SECOND,FIRST);
    }

    public static List<Rank> getAllRanks() {
        return Arrays.asList(MISS, FIFTH,FOURTH,THIRD,SECOND,FIRST);
    }

    public static int getCountOfMatch(Rank rank) {
        return rank.getMatchBonus().getCountOfMatch();
    }
}

class MatchBonus {

    private int countOfMatch;
    private boolean bonus;

    final static MatchBonus MATCH_COUNT_MISS = new MatchBonus(0, false);

    final static Map<Integer, MatchBonus> MATCH_COUNT_BY_MATCH_BONUS_FALSE = new HashMap<Integer, MatchBonus>() {
        {
            put(6, new MatchBonus(6, false));
            put(5, new MatchBonus(5, false));
            put(4, new MatchBonus(4, false));
            put(3, new MatchBonus(3, false));
        }
    };

    final static Map<Integer, MatchBonus> MATCH_COUNT_BY_MATCH_BONUS_TRUE = new HashMap<Integer, MatchBonus>() {
        {
            put(5, new MatchBonus(5, true));
        }
    };

    MatchBonus(int countOfMatch, boolean bonus) {
        this.countOfMatch = countOfMatch;
        this.bonus = bonus;
    }

    int getCountOfMatch() {
        return countOfMatch;
    }

    static MatchBonus of(int countOfMatch, boolean bonus) {
        if(!MATCH_COUNT_BY_MATCH_BONUS_TRUE.keySet().contains(countOfMatch) &&
                !MATCH_COUNT_BY_MATCH_BONUS_FALSE.keySet().contains(countOfMatch)) {
            return MATCH_COUNT_MISS;
        }
        if(!MATCH_COUNT_BY_MATCH_BONUS_TRUE.keySet().contains(countOfMatch)) {
            bonus = false;
        }
        if(bonus) {
            return MATCH_COUNT_BY_MATCH_BONUS_TRUE.get(countOfMatch);
        }
        return MATCH_COUNT_BY_MATCH_BONUS_FALSE.get(countOfMatch);
    }
}


