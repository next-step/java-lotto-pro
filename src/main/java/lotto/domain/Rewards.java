package lotto.domain;

import java.util.List;

public class Rewards {
    private static final int LOTTO_PRICE = 1000;
    private final List<Rank> rankList;
    private final double totalPrize;

    public Rewards(List<Rank> rankList) {
        this.rankList = rankList;
        this.totalPrize = calculateTotalPrize(rankList);
    }

    private static long calculateTotalPrize(final List<Rank> rankList) {
        return rankList.stream()
                .mapToLong(Rank::getWinningMoney)
                .sum();
    }

    public int count(final Rank rank) {
        return (int) this.rankList.stream()
                .filter(it -> it == rank)
                .count();
    }

    public double calculateRateReward() {
        double purchaseAmount = this.rankList.size() * LOTTO_PRICE;
        return totalPrize / purchaseAmount;
    }
}
