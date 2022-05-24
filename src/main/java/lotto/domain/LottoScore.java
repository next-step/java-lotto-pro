package lotto.domain;

import java.util.Map;

public class LottoScore {
    private Map<Rank, Integer> lottoScore;

    public LottoScore(Map<Rank, Integer> lottoScore) {
        this.lottoScore = lottoScore;
    }

    public Map<Rank, Integer> getLottoScore() {
        return this.lottoScore;
    }

    public double calculatorProfit(int amount) {
        double result = 0;
        for (Map.Entry<Rank, Integer> lottoStatistic : this.lottoScore.entrySet()) {
            result += lottoStatistic.getKey().calculatorProfit(lottoStatistic.getValue());
        }
        return result/amount;
    }
}
