package lotto;

import lotto.common.Constants;

import java.util.HashMap;
import java.util.Map;

import static lotto.common.Constants.ZERO;

// 일급콜렉션
public class MatchNumberMap {
    Map<Rank, Integer> matchNumberMap;

    public MatchNumberMap() {
        this.matchNumberMap = new HashMap<>();
    }

    public int value(Rank rank) {
        if (!matchNumberMap.containsKey(rank)) {
            return Constants.INIT_NUM;
        }
        return matchNumberMap.get(rank);
    }

    public float profit() {
        if (matchNumberMap.containsKey(null)) {
            return ZERO;
        }
        float profit = Constants.INIT_NUM;
        for (Rank keyRank : matchNumberMap.keySet()) {
            profit += keyRank.getWinningMoney() * matchNumberMap.get(keyRank);
        }
        return profit;
    }

    public void put(Rank rank, int cnt) {
        this.matchNumberMap.put(rank, cnt);
    }

    public int get(Rank rank) {
        if (this.matchNumberMap.containsKey(rank)) {
            return this.matchNumberMap.get(rank);
        }
        return ZERO;
    }
}
