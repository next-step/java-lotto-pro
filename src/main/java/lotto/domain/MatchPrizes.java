package lotto.domain;

import java.util.Map;

public class MatchPrizes {

    private final Map<Match, Integer> matchPrizes;

    public MatchPrizes(Map<Match, Integer> matchPrizes) {
        this.matchPrizes = matchPrizes;
    }

    public boolean has(Match match) {
        if (matchPrizes.get(match) != null) {
            return true;
        }
        return false;
    }

    public int prizeMoney(Match match) {
        return matchPrizes.getOrDefault(match, 0);
    }
}
