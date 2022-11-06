package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchBonus {

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
