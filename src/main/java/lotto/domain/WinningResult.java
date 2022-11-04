package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int DEFAULT_ADD_VALUE = 1;
    private final Map<WinningLottoRank, Integer> ranks;

    public WinningResult() {
        ranks = new HashMap<>();
        for (WinningLottoRank value : WinningLottoRank.values()) {
            ranks.put(value, ranks.getOrDefault(value, DEFAULT_VALUE));
        }
    }

    public Map<WinningLottoRank, Integer> reportRanks(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            addRank(winningLotto.rank(lotto));
        }
        return new HashMap<>(ranks);
    }

    public void addRank(WinningLottoRank rank) {
        ranks.put(rank, ranks.get(rank) + DEFAULT_ADD_VALUE);
    }

    public double reportYield(PurchaseAmount purchaseAmount) {
        int totalReward = 0;
        for (WinningLottoRank rank : ranks.keySet()) {
            totalReward += ranks.get(rank) * rank.getReward();
        }
        return (double) totalReward / (double) purchaseAmount.purchaseAmount();
    }
}
