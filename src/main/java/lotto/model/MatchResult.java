package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lotto.model.enums.Rank;

public class MatchResult {
    private final Map<Rank, Integer> rankToCount;
    private final RateOfReturn rateOfReturn;

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

    public RateOfReturn getRateOfReturn() {
        return rateOfReturn;
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
        MatchResult that = (MatchResult)obj;
        return Objects.equals(rankToCount, that.rankToCount) && Objects.equals(rateOfReturn, that.rateOfReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankToCount, rateOfReturn);
    }
}
