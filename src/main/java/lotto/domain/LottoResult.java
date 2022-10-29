package lotto.domain;

import lotto.enums.LottoRank;

import java.util.LinkedHashMap;

public class LottoResult {

    private final LinkedHashMap<LottoRank, Integer> lottoResultMap;

    public LottoResult() {
        lottoResultMap = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoResultMap.put(rank, 0);
        }
    }

    public void increaseRankCount(LottoRank rank) {
        lottoResultMap.put(rank, lottoResultMap.get(rank) + 1);
    }

    public double lottoProfitPercent(int purchasePrice) {
        double sumOfRankingAmount = 0;
        for (LottoRank rank : lottoResultMap.keySet()) {
            sumOfRankingAmount += rank.getReward() * lottoResultMap.get(rank);
        }
        return Math.floor(sumOfRankingAmount / purchasePrice * 100) / 100.0;
    }

    public LinkedHashMap<LottoRank, Integer> getLottoResultMap() {
        return lottoResultMap;
    }
}
