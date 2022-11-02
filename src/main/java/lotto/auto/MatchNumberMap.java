package lotto.auto;

import java.util.Map;

import static lotto.auto.common.Constants.INIT_NUM;
import static lotto.auto.common.Constants.ZERO;

// 일급콜렉션
public class MatchNumberMap {
    Map<Rank, Integer> matchNumberMap;

    public MatchNumberMap(Map<Rank, Integer> matchNumberMap) {
        this.matchNumberMap = matchNumberMap;
    }

    public int value(Rank rank) {
        if (!matchNumberMap.containsKey(rank)) {
            return INIT_NUM;
        }
        return matchNumberMap.get(rank);
    }

    public float profit() {
        if (matchNumberMap.containsKey(null)) {
            return ZERO;
        }
        float profit = INIT_NUM;
        for (Rank keyRank : matchNumberMap.keySet()) {
            profit += keyRank.getWinningMoney() * matchNumberMap.get(keyRank);
        }
        return profit;
    }
}
