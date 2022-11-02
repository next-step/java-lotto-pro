package lotto.domain;

import java.util.Map;

public class StatisticsResult {

    private final Map<Rank, Integer> countsOfRanks;
    private final Yields yields;

    public StatisticsResult(final Map<Rank, Integer> countsOfRanks, final Yields yields) {
        this.countsOfRanks = countsOfRanks;
        this.yields = yields;
    }

    public Map<Rank, Integer> getCountsOfRanks() {
        return countsOfRanks;
    }

    public Yields getYields() {
        return yields;
    }
}
