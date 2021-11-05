package lotto.domain;

import java.util.Map;

public class Revenue {

    private double value;

    public Revenue(long amount, Map<Integer, Integer> statistic) {
        long sum = statistic.entrySet().stream()
                .mapToLong(e -> Winnings.getAmount(e.getKey()) * e.getValue())
                .sum();

        this.value = Math.floor(calculate(toDouble(sum), toDouble(amount)) * 100) / 100;
    }

    private double calculate(double sum, double amount) {
        return sum / amount;
    }

    private double toDouble(long amount) {
        return (double) amount;
    }

    public double percentage() {
        return this.value;
    }
}
