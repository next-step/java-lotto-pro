package lotto.domain;

import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> winningCount = new HashMap<>();
    double profitRate;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        updateWinningCount(lottos, winningLotto);
        updateProfitRate(lottos.size());
    }

    private void updateWinningCount(Lottos lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.matchRank(lotto.countMatchedNumbers(winningLotto));
            winningCount.put(rank, winningCount.getOrDefault(rank, 0) + 1);
        }
    }

    private void updateProfitRate(int lottoCount) {
        if(lottoCount == 0){
            profitRate = 0;
            return;
        }
        profitRate = (double) calculateTotalPrice() / (lottoCount * Money.LOTTO_PRICE);
    }

    private int calculateTotalPrice() {
        int price = 0;
        for (LottoRank rank : LottoRank.values()) {
            price += winningCount.getOrDefault(rank, 0) * rank.getPrice();
        }
        return price;
    }

    public int winningCountByRank(LottoRank rank) {
        return winningCount.getOrDefault(rank, 0);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
