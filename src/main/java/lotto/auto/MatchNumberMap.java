package lotto.auto;

import java.util.Map;

import static lotto.auto.common.Constants.INIT_NUM;

// 일급콜렉션
public class MatchNumberMap {
    Map<Rank, Integer> matchNumberMap;

    public MatchNumberMap(Map<Rank, Integer> matchNumberMap) {
        this.matchNumberMap = matchNumberMap;
    }

    public Map<Rank, Integer> getMatchNumberMap() {
        return matchNumberMap;
    }

    public int value(Rank rank) {
        if (!matchNumberMap.containsKey(rank)) {
            return INIT_NUM;
        }
        return matchNumberMap.get(rank);
    }

    public float profit() {
        float profit = INIT_NUM;
        for (Rank keyRank : matchNumberMap.keySet()) {
            profit += keyRank.getWinningMoney() * matchNumberMap.get(keyRank);
        }
        return profit;
    }
}
