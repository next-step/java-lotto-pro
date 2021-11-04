package lotto.domain;

import java.util.List;

public class Result {

    private final List<Rank> ranks;
    private final Money money;

    public Result(List<Rank> ranks, Money money) {
        this.ranks = ranks;
        this.money = money;
    }

    public double getProfitRate() {
        final int sum = ranks.stream()
                .mapToInt(Rank::getPrice)
                .sum();

        return money.profitRate(sum);
    }
}
