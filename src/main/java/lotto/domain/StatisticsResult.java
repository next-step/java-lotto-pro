package lotto.domain;

import java.util.Map;

public class StatisticsResult {

    private final Map<Rank, Integer> countsOfRanks;
    private final Double profit;

    public StatisticsResult(final Map<Rank, Integer> countsOfRanks, final Double profit) {
        this.countsOfRanks = countsOfRanks;
        this.profit = profit;
    }

    public Map<Rank, Integer> getCountsOfRanks() {
        return countsOfRanks;
    }

    public Double getProfit() {
        return profit;
    }
}
