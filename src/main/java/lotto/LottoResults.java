package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {
    public static final int PROFIT_BASE = 1;
    private final Map<LottoRankingStatus, Integer> lottoRankingAmountMap;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoRankingAmountMap = new LinkedHashMap<>();
        generateLottoRankingMap(lottoResults);
    }

    private void generateLottoRankingMap(List<LottoResult> lottoResults) {
        for (LottoRankingStatus lottoRankingStatus: LottoRankingStatus.values()) {
            lottoRankingAmountMap.put(lottoRankingStatus, 0);
        }

        for (LottoResult lottoResult: lottoResults) {
            LottoRankingStatus lottoRankingStatus = lottoResult.getResultRanking();
            lottoRankingAmountMap.put(lottoRankingStatus, lottoRankingAmountMap.getOrDefault(lottoRankingStatus, 0) + 1);
        }
    }

    public int getMatchAmount(int matchAmount) {
        return lottoRankingAmountMap.get(
                LottoRankingStatus.getLottoRankingFromMatchAmount(matchAmount)
        );
    }

    public int getTotalReward() {
        return lottoRankingAmountMap.keySet()
                .stream()
                .mapToInt(lrs -> lrs.getPrizeReward(lottoRankingAmountMap.get(lrs)))
                .sum();
    }

    public double getProfitRate(BuyAmount buyAmount) {
        int totalReward = getTotalReward();
        return PROFIT_BASE + buyAmount.getProfitRate(totalReward);
    }
}
