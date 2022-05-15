package lotto.domain;

import lotto.enums.LottoRankType;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    Map<LottoRankType, Integer> winningCount = new HashMap<>();
    double profitRate;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        updateWinningCount(lottos, winningLotto);
        updateProfitRate(lottos.size());
    }

    private void updateWinningCount(Lottos lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoRankType winningType = LottoRankType.matchRankType(lotto, winningLotto);
            winningCount.put(winningType, winningCount.getOrDefault(winningType, 0) + 1);
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
        for (LottoRankType type : LottoRankType.values()) {
            price += winningCount.getOrDefault(type, 0) * type.getPrice();
        }
        return price;
    }

    public int winningCountByWinningType(LottoRankType type) {
        return winningCount.getOrDefault(type, 0);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
