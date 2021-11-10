package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;
    private static final int DECIMAL_CALCULATION_NUMBER = 100;

    private final Map<LottoRank, Integer> lottoResults;

    public LottoResult(List<Lotto> lottos, WinningNumber winningNumber) {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = LottoRank.valueOf(getMatchCount(winningNumber, lotto), lotto.contains(winningNumber.getBonusBall()));
            results.put(lottoRank, results.getOrDefault(lottoRank, DEFAULT_VALUE) + ADD_COUNT);
        }
        this.lottoResults = results;
    }

    private int getMatchCount(WinningNumber winningNumber, Lotto lotto) {
        return lotto.winningCount(winningNumber.getWinningLotto());
    }

    public int getResult(LottoRank key) {
        return lottoResults.getOrDefault(key, DEFAULT_VALUE);
    }

    public double rewardRatio() {
        Set<LottoRank> lottoRanks = lottoResults.keySet();
        return rateCalculation(getTotalReward(lottoRanks), getPurchaseAmount(lottoRanks));
    }

    public static double rateCalculation(long totalReward, double purchaseAmount) {
        return Math.floor((totalReward / purchaseAmount) * DECIMAL_CALCULATION_NUMBER) / DECIMAL_CALCULATION_NUMBER;
    }

    private long getPurchaseAmount(Set<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToLong(lottoResults::get)
                .sum() * Money.PRICE_ONE_LOTTO;
    }

    private long getTotalReward(Set<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToLong(lottoRank -> lottoRank.getTotal(lottoResults.get(lottoRank)))
                .sum();
    }
}
