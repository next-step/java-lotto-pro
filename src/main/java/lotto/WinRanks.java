package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinRanks {
    private final Map<Integer, Rank> winMap;

    public WinRanks() {
        winMap = new HashMap<>();
        winMap.put(3, new Rank(3, 5_000, 0));
        winMap.put(4, new Rank(4, 50_000, 0));
        winMap.put(5, new Rank(5, 1_500_000, 0));
        winMap.put(6, new Rank(6, 2_000_000_000, 0));
    }

    public Map<Integer, Rank> getWinMap() {
        return winMap;
    }

    public int winningPrice(Lotto winningLotto, Lottos lottos) {
        int totalPrice = 0;
        calculateWinPriceMap(winningLotto, lottos);
        for (Integer key : winMap.keySet()) {
            Rank rank = winMap.get(key);
            totalPrice += rank.calculateTotalPrice();
        }
        return totalPrice;
    }

    public void calculateWinPriceMap(Lotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            int checkMatchCount = lotto.checkMatchCount(winningLotto);
            addRankCount(winMap, checkMatchCount);
        }
    }

    private void addRankCount(Map<Integer, Rank> winMap, int checkMatchCount) {
        if (winMap.containsKey(checkMatchCount)) {
            Rank rank = winMap.get(checkMatchCount);
            rank.addCount();
        }
    }
}