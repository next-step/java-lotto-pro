package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {
    public static final double PROFIT_RATE_DECIMAL_POINT = 100.0;
    public static final int PROFIT_BASE = 1;
    private final Map<LottoRankingStatus, Integer> lottoRankingAmounts;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoRankingAmounts = new LinkedHashMap<>();
        generateLottoRankingMap(lottoResults);
    }

    private void generateLottoRankingMap(List<LottoResult> lottoResults) {
        for (LottoRankingStatus lottoRankingStatus : LottoRankingStatus.values()) {
            lottoRankingAmounts.put(lottoRankingStatus, 0);
        }

        for (LottoResult lottoResult : lottoResults) {
            LottoRankingStatus lottoRankingStatus = lottoResult.getResultRankingStatus();
            lottoRankingAmounts.put(lottoRankingStatus, lottoRankingAmounts.getOrDefault(lottoRankingStatus, 0) + 1);
        }
    }

    public Map<LottoRankingStatus, Integer> getLottoRankingAmounts() {
        return lottoRankingAmounts;
    }

    public int getMatchAmount(int matchAmount, boolean matchBonus) {
        return lottoRankingAmounts.get(
                LottoRankingStatus.valueOf(matchAmount, matchBonus)
        );
    }

    public long getTotalReward() {
        return lottoRankingAmounts.keySet()
                .stream()
                .mapToLong(lottoRankingStatus -> lottoRankingStatus.getPrizeReward(lottoRankingAmounts.get(lottoRankingStatus)))
                .sum();
    }

    public double getProfitRate(PurchaseInfo purchaseInfo) {
        long totalReward = getTotalReward();

        return Math.floor((PROFIT_BASE + purchaseInfo.getProfitRate(totalReward)) * PROFIT_RATE_DECIMAL_POINT)
                / PROFIT_RATE_DECIMAL_POINT;
    }
}
