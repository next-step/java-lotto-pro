package study.lotto.model;

public class IncomeRate {

    private final double incomeRate;

    public IncomeRate(final int income, final int ticketCount) {
        this.incomeRate = calculateIncomeRate(income, ticketCount);
    }

    public static IncomeRate valueOf(int income, final int ticketCount) {
        return new IncomeRate(income, ticketCount);
    }

    private double calculateIncomeRate(final int income, final int ticketCount) {
        final double incomeRate = (double) income / (ticketCount * LottoStore.PRICE_OF_LOTTO_TICKET);
        return Math.floor(incomeRate * 100) / 100.0;

    }

    public double getIncomeRate() {
        return incomeRate;
    }
}
