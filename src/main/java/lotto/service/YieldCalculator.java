package lotto.service;

import lotto.model.Money;
import lotto.model.Summary;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class YieldCalculator {
    private YieldCalculator() {
    }

    public static double earningsRate(Summary summary, Money money) {
        BigDecimal value1 = BigDecimal.valueOf(summary.totalPrizeMoney());
        BigDecimal value2 = BigDecimal.valueOf(money.value());
        return value1.divide(value2, 2, RoundingMode.FLOOR).doubleValue();
    }
}
