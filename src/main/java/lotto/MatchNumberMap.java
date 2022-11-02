package lotto;

import lotto.common.Constants;

import java.util.Map;

// 일급콜렉션
public class MatchNumberMap {
    Map<Rank, Integer> matchNumberMap;

    public MatchNumberMap(Map<Rank, Integer> matchNumberMap) {
        this.matchNumberMap = matchNumberMap;
    }

    public int value(Rank rank) {
        if (!matchNumberMap.containsKey(rank)) {
            return Constants.INIT_NUM;
        }
        return matchNumberMap.get(rank);
    }

    public float profit() {
        if (matchNumberMap.containsKey(null)) {
            return Constants.ZERO;
        }
        float profit = Constants.INIT_NUM;
        for (Rank keyRank : matchNumberMap.keySet()) {
            profit += keyRank.getWinningMoney() * matchNumberMap.get(keyRank);
        }
        return profit;
    }
}
