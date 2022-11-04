package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0,0);

    private final int countOfMatch;
    private final int winningMoney;
    private final static Map<MatchBonus, Rank> RANK_BY_MATCH_COUNT = new HashMap<MatchBonus, Rank>() {
        {
            put(MatchBonus.of(0, true), MISS);
            put(MatchBonus.of(0, false), MISS);
            put(MatchBonus.of(1, true), MISS);
            put(MatchBonus.of(1, false), MISS);
            put(MatchBonus.of(2, true), MISS);
            put(MatchBonus.of(2, false), MISS);
            put(MatchBonus.of(3, true), FIFTH);
            put(MatchBonus.of(3, false), FIFTH);
            put(MatchBonus.of(4, true), FOURTH);
            put(MatchBonus.of(4, false), FOURTH);
            put(MatchBonus.of(5, true), SECOND);
            put(MatchBonus.of(5, false), THIRD);
            put(MatchBonus.of(6, true), FIRST);
            put(MatchBonus.of(6, false), FIRST);

        }
    };

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return RANK_BY_MATCH_COUNT.get(MatchBonus.of(countOfMatch,matchBonus));
    }

    public static List<Rank> getAllRanks() {
        return Arrays.asList(FIRST,SECOND,THIRD,FOURTH,FIFTH,MISS);
    }

    public static List<Rank> getAllRanksExceptMiss() {
        return Arrays.asList(FIFTH,FOURTH,THIRD,SECOND,FIRST);
    }
}


