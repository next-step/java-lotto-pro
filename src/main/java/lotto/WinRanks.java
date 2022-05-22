package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinRanks {
    private final Map<Rank, Integer> winMap;

    public WinRanks() {
        winMap = new HashMap<>();
        winMap.put(Rank.FIRST, 0);
        winMap.put(Rank.THIRD, 0);
        winMap.put(Rank.FOURTH, 0);
        winMap.put(Rank.FIFTH, 0);
    }

    public Map<Rank, Integer> getWinMap() {
        return winMap;
    }

    public int winningPrice(Lotto winningLotto, Lottos lottos) {
        int totalPrice = 0;
        calculateWinPriceMap(winningLotto, lottos);
        for (Rank rankEnum : winMap.keySet()) {
            totalPrice += winMap.get(rankEnum) * rankEnum.getWinningMoney();
        }
        return totalPrice;
    }

    public void calculateWinPriceMap(Lotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            int checkMatchCount = lotto.checkMatchCount(winningLotto);
            addRankCount(winMap, checkMatchCount);
        }
    }

    private void addRankCount(Map<Rank, Integer> winMap, int checkMatchCount) {
        Rank key = Rank.valueOf(checkMatchCount);
        if (winMap.containsKey(key)) {
            winMap.put(key, winMap.get(key) + 1);
        }
    }
}