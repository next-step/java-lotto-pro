package lotto.model;

import java.math.BigDecimal;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoRanking, Integer> lottoStatistics;

    public LottoStatistics(Map<LottoRanking, Integer> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public BigDecimal yield(Money money) {
        return sumTotalPrize().divideBy(money);
    }

    private Money sumTotalPrize() {
        Money totalPrize = Money.from(0);
        for (Map.Entry<LottoRanking, Integer> entry : lottoStatistics.entrySet()) {
            LottoRanking lottoRanking = entry.getKey();
            Money prize = lottoRanking.money()
                    .multiply(entry.getValue());
            totalPrize = totalPrize.add(prize);
        }
        return totalPrize;
    }

    public int get(LottoRanking lottoRanking) {
        return lottoStatistics.getOrDefault(lottoRanking, 0);
    }
}
