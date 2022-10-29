package step3.domain;

import java.util.List;

public class Rewards {
    private static final long LOTTO_PRICE = 1000L;
    private final List<Rank> rankList;
    private final long totalPrize;

    public Rewards(final List<Rank> rankList) {
        this.rankList = rankList;
        this.totalPrize = calculateTotalPrize(rankList);
    }

    private static long calculateTotalPrize(final List<Rank> rankList) {
        return rankList.stream()
                .mapToLong(Rank::prize)
                .sum();
    }

    public int count(final Rank rank) {
        return (int) this.rankList.stream()
                .filter(it -> it == rank)
                .count();
    }

    public double calculateRateOfReturn() {
        double investAmount = this.rankList.size() * LOTTO_PRICE;
        return totalPrize / investAmount;
    }
}
