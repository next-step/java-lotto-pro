package lotto.model;

import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int size() {
        return ranks.size();
    }

    public double getReturnOnInvestment(Money investment) {
        final Money totalReward = ranks.stream()
                .map(Rank::getReward)
                .reduce(new Money(0), Money::plus);
        return totalReward.divideBy(investment);
    }

    public long getCountOf(Rank rank) {
        return ranks.stream().filter(w -> w.equals(rank))
                .count();
    }
}
