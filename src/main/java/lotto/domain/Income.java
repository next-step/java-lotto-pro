package lotto.domain;

import java.util.Map;

public class Income {

    private final Map<Integer, Integer> statistic;

    public Income(final Map<Integer, Integer> statistic) {
        this.statistic = statistic;
    }

    public Amount amount() {
        long sum = statistic.entrySet().stream()
                .mapToLong(e -> Winnings.getAmount(e.getKey()) * e.getValue())
                .sum();
        return new Amount(sum);
    }
}
