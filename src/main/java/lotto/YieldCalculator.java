package lotto;

import lotto.domain.Money;
import lotto.domain.Summary;

public class YieldCalculator {
    private YieldCalculator() {
    }

    public static double earningsRate(Summary summary, Money money) {
        return 1.0 * summary.sum() / money.value();
    }
}
