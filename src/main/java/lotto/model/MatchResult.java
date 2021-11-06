package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MatchResult {
    private final Map<MatchCount, Integer> matchCountToCount = new HashMap<>();
    private final double rateOfReturn;

    public MatchResult(Payment payment, MatchCount... matchCounts) {
        this(payment, Arrays.asList(matchCounts));
    }

    public MatchResult(Payment payment, List<MatchCount> matchCounts) {
        initialize();

        int prizeMoney = 0;
        for (MatchCount matchCount : matchCounts) {
            matchCountToCount.merge(matchCount, 1, Integer::sum);
            prizeMoney += matchCount.getPrizeMoney();
        }
        rateOfReturn = payment.getRateOfReturn(prizeMoney);
    }

    private void initialize() {
        for (MatchCount value : MatchCount.values()) {
            matchCountToCount.put(value, 0);
        }
    }

    public Map<MatchCount, Integer> getMatchCountToCount() {
        return matchCountToCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MatchResult other = (MatchResult)obj;
        return Double.compare(other.rateOfReturn, rateOfReturn) == 0
            && matchCountToCount.equals(other.matchCountToCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCountToCount, rateOfReturn);
    }
}
