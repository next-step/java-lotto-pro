package lotto.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lotto.model.enums.Rank;

public class MatchResult {
    private final Map<Rank, Integer> rankToCount;
    private final RateOfReturn rateOfReturn;

    public MatchResult(Payment payment, Rank... ranks) {
        this(payment, Arrays.asList(ranks));
    }

    public MatchResult(Payment payment, Collection<Rank> ranks) {
        Objects.requireNonNull(payment);
        Objects.requireNonNull(ranks);

        rankToCount = new HashMap<>();
        initialize();

        int winningMoney = 0;
        for (Rank rank : ranks) {
            rankToCount.merge(rank, 1, Integer::sum);
            winningMoney += rank.getWinningMoney();
        }
        rateOfReturn = payment.computeRateOfReturn(winningMoney);
    }

    private void initialize() {
        for (Rank value : Rank.values()) {
            rankToCount.put(value, 0);
        }
    }

    public int countRank(Rank rank) {
        return rankToCount.get(Objects.requireNonNull(rank));
    }

    public RateOfReturn getRateOfReturn() {
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
        MatchResult that = (MatchResult)obj;
        return Objects.equals(rankToCount, that.rankToCount) && Objects.equals(rateOfReturn, that.rateOfReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankToCount, rateOfReturn);
    }
}
