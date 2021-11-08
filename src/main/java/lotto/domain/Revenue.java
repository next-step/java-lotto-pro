package lotto.domain;

import java.util.Map;

public class Revenue {

    private final Amount amount;
    private final Map<Winnings, Integer> statistic;

    public Revenue(Amount amount, Map<Winnings, Integer> statistic) {
        this.amount = amount;
        this.statistic = statistic;
    }

    private Amount incomeAmount() {
        return new Income(statistic).amount();
    }

    public double profitRate() {
        Amount incomeAmount = incomeAmount();
        return Math.floor(incomeAmount.divideToDouble(amount) * 100) / 100;
    }
}
