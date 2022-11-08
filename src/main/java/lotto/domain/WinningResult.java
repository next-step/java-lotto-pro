package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static lotto.domain.PurchaseAmount.LOTTO_TICKET_PRICE;

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

    public Map<WinningLottoRank, Integer> reportRanks() {
        return Collections.unmodifiableMap(ranks);
    }

    public double reportYield() {
        return (double) totalReward() / (double) totalPurchaseAmount();
    }

    private long totalReward() {
        return ranks.keySet()
                .stream()
                .mapToLong(rank -> rank.getReward() * ranks.get(rank))
                .sum();
    }

    private int totalPurchaseAmount() {
        return ranks.keySet()
                .stream()
                .mapToInt(ranks::get)
                .sum() * LOTTO_TICKET_PRICE;
    }
}
