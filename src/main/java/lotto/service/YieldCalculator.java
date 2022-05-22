package lotto.service;

import lotto.model.Money;
import lotto.model.Summary;

public class YieldCalculator {
    private YieldCalculator() {
    }

    public static double earningsRate(Summary summary, Money money) {
        return 1.0 * summary.totalPrizeMoney() / money.value();
    }
}
