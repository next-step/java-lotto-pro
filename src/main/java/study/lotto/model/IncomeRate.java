package study.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeRate {

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

        final BigDecimal divide = income
                .divide(BigDecimal.valueOf(ticketCount)
                        .multiply(BigDecimal.valueOf(LottoStore.PRICE_OF_LOTTO_TICKET)), RoundingMode.DOWN
                );
        return Math.floor(divide.doubleValue() * 100) / 100.0;

    }

    public double getIncomeRate() {
        return incomeRate;
    }
}
