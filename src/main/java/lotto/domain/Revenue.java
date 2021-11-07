package lotto.domain;

import java.util.Map;

public class Revenue {

    private final PurchaseAmount amount;
    private final Map<Integer, Integer> statistic;

    public Revenue(PurchaseAmount amount, Map<Integer, Integer> statistic) {
        this.amount = amount;
        this.statistic = statistic;
    }

    private Amount incomeAmount() {
        return new Income(statistic).amount();
    }

    public double percentage() {
        Amount incomeAmount = incomeAmount();
        return Math.floor(incomeAmount.divideToDouble(amount) * 100) / 100;
    }
}
