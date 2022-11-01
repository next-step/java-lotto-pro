package step3.domain;

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

    public void addRank(WinningLottoRank rank) {
        ranks.put(rank, ranks.get(rank) + DEFAULT_ADD_VALUE);
    }

    public double getYield(PurchaseAmount purchaseAmount) {
        int totalReward = 0;
        for (WinningLottoRank rank : ranks.keySet()) {
            totalReward += ranks.get(rank) * rank.getReward();
        }
        return (double) totalReward / (double) purchaseAmount.purchaseAmount();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for (WinningLottoRank rank : WinningLottoRank.values()) {
            sb.append(rank);
            sb.append("- ");
            sb.append(ranks.get(rank));
            sb.append("개\n");
        }
        return sb.toString();
    }
}
