package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lotto.model.enums.Rank;

public class MatchResult {
    private static final int BREAK_EVEN_RATE = 1;

    private final Map<Rank, Integer> rankToCount;
    private final double rateOfReturn;

    public MatchResult(Payment payment, Rank... ranks) {
        this(payment, Arrays.asList(ranks));
    }

    public MatchResult(Payment payment, List<Rank> ranks) {
        rankToCount = new HashMap<>();
        initialize();

        int prizeMoney = 0;
        for (Rank rank : ranks) {
            rankToCount.merge(rank, 1, Integer::sum);
            prizeMoney += rank.getWinningMoney();
        }
        rateOfReturn = payment.getRateOfReturn(prizeMoney);
    }

    private void initialize() {
        for (Rank value : Rank.values()) {
            rankToCount.put(value, 0);
        }
    }

    public Map<Rank, Integer> getRankToCount() {
        return rankToCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public boolean isLosingMoney() {
        return rateOfReturn < BREAK_EVEN_RATE;
    }

    public int getCount(Rank rank) {
        return rankToCount.get(rank);
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
            && rankToCount.equals(other.rankToCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankToCount, rateOfReturn);
    }
}
