package lotto.domain;

import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> winningCount = new HashMap<>();

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        updateWinningCount(lottos, winningLotto);
    }

    private void updateWinningCount(Lottos lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.matchRank(lotto.countMatchedNumbers(winningLotto));
            winningCount.put(rank, winningCount.getOrDefault(rank, 0) + 1);
        }
    }

    public int winningPrice() {
        int winningPrice = 0;
        for (LottoRank rank : LottoRank.values()) {
            winningPrice += winningCount.getOrDefault(rank, 0) * rank.getPrice();
        }
        return winningPrice;
    }

    public int winningCountByRank(LottoRank rank) {
        return winningCount.getOrDefault(rank, 0);
    }
}
