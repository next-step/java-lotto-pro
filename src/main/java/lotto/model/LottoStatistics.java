package lotto.model;

import java.math.BigDecimal;
import java.util.Map;

public class LottoStatistics {
    private static final int ZERO_NUM = 0;
    private final Map<LottoRanking, Integer> lottoStatistics;

    public LottoStatistics(Map<LottoRanking, Integer> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public int winningLottoCount(LottoRanking lottoRanking) {
        return lottoStatistics.getOrDefault(lottoRanking, ZERO_NUM);
    }

    public BigDecimal yield(Money money) {
        return sumTotalPrize().divideBy(money);
    }

    private Money sumTotalPrize() {
        Money totalPrize = Money.valueOf(ZERO_NUM);
        for (Map.Entry<LottoRanking, Integer> entry : lottoStatistics.entrySet()) {
            LottoRanking lottoRanking = entry.getKey();
            Money prize = lottoRanking.money()
                    .multiply(entry.getValue());
            totalPrize = totalPrize.add(prize);
        }
        return totalPrize;
    }
}
