package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class Statistics {
    private final Map<Rank, Long> rankCounts;
    private final EarningRate earningRate;

    public Statistics(Map<Rank, Long> rankCounts, EarningRate earningRate) {
        this.rankCounts = rankCounts;
        this.earningRate = earningRate;
    }

    public Map<Rank, Long> getRankCounts() {
        return rankCounts;
    }

    public EarningRate getEarningRate() {
        return earningRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Statistics)) {
            return false;
        }
        Statistics that = (Statistics)o;
        return Objects.equals(rankCounts, that.rankCounts) && Objects.equals(earningRate, that.earningRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCounts, earningRate);
    }
}
