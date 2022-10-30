package lotto.domain;

import lotto.enums.LottoRank;

import java.util.LinkedHashMap;

public class LottoResult {

    private final LinkedHashMap<LottoRank, Integer> lottoResultMap;
    private static final int COUNTING = 1;
    private static final double DIVIDE_PERCENT = 100.0f;

    public LottoResult() {
        lottoResultMap = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoResultMap.put(rank, 0);
        }
    }

    public void increaseRankCount(LottoRank rank) {
        lottoResultMap.put(rank, lottoResultMap.get(rank) + COUNTING);
    }

    public double lottoProfitPercent(int purchasePrice) {
        double sumOfRankingAmount = 0;
        for (LottoRank rank : lottoResultMap.keySet()) {
            sumOfRankingAmount += rank.getReward() * lottoResultMap.get(rank);
        }
        return Math.floor(sumOfRankingAmount / purchasePrice * DIVIDE_PERCENT) / DIVIDE_PERCENT;
    }

    public LinkedHashMap<LottoRank, Integer> getLottoResultMap() {
        return lottoResultMap;
    }

}
