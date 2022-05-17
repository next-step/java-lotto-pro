package lotto.domain;

import java.util.LinkedHashMap;

public class WinningStatistics {

    private LinkedHashMap<LottoRanking, Integer> lottoRankingCount;

    public WinningStatistics() {
        lottoRankingCount = new LinkedHashMap<>();
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            lottoRankingCount.put(lottoRanking, 0);
        }
    }

    public int addLottoRanking(LottoRanking lottoRanking) {
        int increaseCount = lottoRankingCount.get(lottoRanking) + 1;
        lottoRankingCount.put(lottoRanking, increaseCount);
        return increaseCount;
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        double sumOfRankingAmount = 0;
        for (LottoRanking lottoRanking : lottoRankingCount.keySet()) {
            sumOfRankingAmount += lottoRanking.getWinAmount() * lottoRankingCount.get(lottoRanking);
        }
        return sumOfRankingAmount / purchaseAmount;
    }
}
