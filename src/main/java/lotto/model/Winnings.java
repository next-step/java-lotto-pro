package lotto.model;

import java.util.List;

public class Winnings {
    private final List<Winning> data;

    public Winnings(List<Winning> data) {
        this.data = data;
    }

    public int size() {
        return data.size();
    }

    public double getReturnOnInvestment(Money investment) {
        final Money totalReward = data.stream()
                .map(Winning::getReward)
                .reduce(new Money(0), Money::plus);
        return totalReward.divideBy(investment);
    }

    public long getCountOf(Winning winning) {
        return data.stream().filter(w -> w.equals(winning))
                .count();
    }
}
