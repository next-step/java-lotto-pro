package study.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class IncomeRate {

    public static final int DECIMAL_SCALE = 2;
    public static final RoundingMode ROUNDING_MODE = RoundingMode.FLOOR;
    private final double incomeRate;

    public IncomeRate(final BigDecimal income, final int ticketCount) {
        this.incomeRate = calculateIncomeRate(income, ticketCount);
    }

    public IncomeRate(final List<Rank> ranks) {
        this(calcIncome(ranks), ranks.size());
    }

    public static IncomeRate valueOf(final BigDecimal income, final int ticketCount) {
        return new IncomeRate(income, ticketCount);
    }

    public static IncomeRate valueOf(final List<Rank> ranks) {
        return new IncomeRate(ranks);
    }

    private static BigDecimal calcIncome(final List<Rank> refereedRanks) {
        BigDecimal income = BigDecimal.ZERO;
        for (final Rank rank : refereedRanks) {
            final BigDecimal winningMoney = BigDecimal.valueOf(rank.getWinningMoney());
            income = income.add(winningMoney);
        }
        return income;
    }

    private double calculateIncomeRate(final BigDecimal income, final int ticketCount) {
        if (income.equals(BigDecimal.ZERO)) {
            return 0.0;
        }

        final BigDecimal incomeRate = income
                .divide(BigDecimal.valueOf(ticketCount)
                        .multiply(BigDecimal.valueOf(LottoStore.PRICE_OF_LOTTO_TICKET)), DECIMAL_SCALE, ROUNDING_MODE
                );
        return incomeRate.doubleValue();

    }

    public double getIncomeRate() {
        return incomeRate;
    }
}
