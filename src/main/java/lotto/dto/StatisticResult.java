package lotto.dto;

import lotto.prize.Prize;

import java.math.BigDecimal;
import java.util.Map;

public class StatisticResult {

    private final Map<Prize, Integer> prizeStatistic;
    private final BigDecimal yield;

    public StatisticResult(Map<Prize, Integer> prizeStatistic, BigDecimal yield) {
        this.prizeStatistic = prizeStatistic;
        this.yield = yield;
    }

    public BigDecimal getYield() {
        return yield;
    }
}
