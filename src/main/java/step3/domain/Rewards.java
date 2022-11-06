package step3.domain;

import java.util.List;

public class Rewards {
    private static final int LOTTO_PRICE = 1000;
    private final List<Rank> rankList;
    private final long totalPrize;

    public Rewards(final List<Rank> rankList) {
        this.rankList = rankList;
        this.totalPrize = calculateTotalPrize(rankList);
    }

    private static long calculateTotalPrize(List<Rank> rankList) {
        return rankList.stream()
            .mapToLong(Rank::winnings)
            .sum();
    }

    public int count(Rank rank) {
        return (int) this.rankList.stream()
            .filter(it -> it == rank)
            .count();
    }

    public double calculateRateOfReturn() {
        double investAmount = this.rankList.size() * LOTTO_PRICE;
        return totalPrize / investAmount;
    }

}
