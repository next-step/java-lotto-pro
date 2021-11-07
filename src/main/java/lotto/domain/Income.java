package lotto.domain;

import java.util.Map;

public class Income {

    private final Map<Winnings, Integer> statistic;

    public Income(final Map<Winnings, Integer> statistic) {
        this.statistic = statistic;
    }

    public Amount amount() {
        long sum = statistic.entrySet().stream()
                .mapToLong(e -> e.getKey().getAmount() * e.getValue())
                .sum();
        return new Amount(sum);
    }
}
