package lotto.model;

import java.util.List;

public class LottoResult {
    private final List<Winning> winnings;

    public LottoResult(List<Winning> winnings) {
        this.winnings = winnings;
    }

    public int size() {
        return winnings.size();
    }

    public double getReturnOnInvestment(Money investment) {
        final Money totalReward = winnings.stream()
                .map(Winning::getReward)
                .reduce(new Money(0), Money::plus);
        return totalReward.divideBy(investment);
    }

    public long getCountOf(Winning winning) {
        return winnings.stream().filter(w -> w.equals(winning))
                .count();
    }
}
