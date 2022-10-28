package lotto.dto;

import lotto.prize.Prize;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticResult {
    private static final String PRIZE_FORMAT = "%s개 일치 (%s원) - %s";
    private static final String YIELD_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final Map<Prize, Integer> prizeStatistic;
    private final BigDecimal yield;

    public StatisticResult(Map<Prize, Integer> prizeStatistic, BigDecimal yield) {
        this.prizeStatistic = prizeStatistic;
        this.yield = yield;
    }

    public BigDecimal getYield() {
        return yield;
    }

    @Override
    public String toString() {
        String statistic = Arrays.stream(Prize.values())
                .sorted(Comparator.comparing(Prize::getMatchCount))
                .map(v -> String.format(PRIZE_FORMAT, v.getMatchCount(), v.getPrizeMoney(), this.prizeStatistic.getOrDefault(v, 0)))
                .collect(Collectors.joining("\n"));
        String yield = String.format(YIELD_FORMAT, this.yield);
        return String.join("\n", statistic, yield);
    }
}
