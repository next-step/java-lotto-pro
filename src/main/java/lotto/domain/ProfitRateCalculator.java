package lotto.domain;

public final class ProfitRateCalculator {

    private ProfitRateCalculator() {
    }

    public static Double compute(final Money investedAmount, final Money earnedAmount) {
        if (investedAmount.isLessThan(Money.ONE)) {
            return Money.ZERO.doubleValue();
        }
        return earnedAmount.divide(investedAmount).doubleValue();
    }

}
