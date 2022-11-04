package lotto.domain;

import java.util.*;

public class MatchBonus {
    
    private int countOfMatch;
    private boolean bonus;
    private static Map<Integer, MatchBonus> matchBonusTrues;
    private static Map<Integer, MatchBonus> matchBonusFalses;
    
    static {
        matchBonusTrues = new HashMap<>();
        matchBonusFalses = new HashMap<>();
        for (int countOfMatch = 0; countOfMatch <= 6; countOfMatch++) {
            matchBonusTrues.put(countOfMatch, new MatchBonus(countOfMatch, true));
            matchBonusFalses.put(countOfMatch, new MatchBonus(countOfMatch, false));    
        }
    }
    
    private MatchBonus(int countOfMatch, boolean bonus) {
        this.countOfMatch = countOfMatch;
        this.bonus = bonus;
    }
    
    public static MatchBonus of(int countOfMatch, boolean bonus) {
        if(bonus) {
            return matchBonusTrues.get(countOfMatch);
        }
        return matchBonusFalses.get(countOfMatch);
    }
    
}
