package lotto.domain;

import lotto.enums.LottoWinningType;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    Map<LottoWinningType, Integer> winningCount = new HashMap<>();
    int totalPrice;
    double profitRate;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        updateWinningCount(lottos, winningLotto);
        updateTotalPrice();
        updateProfitRate(lottos.size());
    }

    private void updateWinningCount(Lottos lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoWinningType winningType = LottoWinningType.match(lotto, winningLotto);
            winningCount.put(winningType, winningCount.getOrDefault(winningType, 0) + 1);
        }
    }

    private void updateTotalPrice() {
        for (LottoWinningType type : LottoWinningType.values()) {
            totalPrice += winningCount.getOrDefault(type, 0) * type.getPrice();
        }
    }

    private void updateProfitRate(int lottoCount) {
        profitRate = (double) totalPrice / (lottoCount * Money.LOTTO_PRICE);
    }

    public int winningCountByWinningType(LottoWinningType type) {
        return winningCount.getOrDefault(type, 0);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
