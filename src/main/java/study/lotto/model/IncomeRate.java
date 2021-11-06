package study.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeRate {

    public static final int DECIMAL_SCALE = 2;
    private final double incomeRate;

    public IncomeRate(final BigDecimal income, final int ticketCount) {
        this.incomeRate = calculateIncomeRate(income, ticketCount);
    }

    public static IncomeRate valueOf(BigDecimal income, final int ticketCount) {
        return new IncomeRate(income, ticketCount);
    }

    private double calculateIncomeRate(final BigDecimal income, final int ticketCount) {
        if (income.equals(BigDecimal.ZERO)) {
            return 0.0;
        }

        final BigDecimal incomeRate = income
                .divide(BigDecimal.valueOf(ticketCount)
                        .multiply(BigDecimal.valueOf(LottoStore.PRICE_OF_LOTTO_TICKET)), DECIMAL_SCALE, RoundingMode.FLOOR
                );
        return incomeRate.doubleValue();

    }

    public double getIncomeRate() {
        return incomeRate;
    }
}
