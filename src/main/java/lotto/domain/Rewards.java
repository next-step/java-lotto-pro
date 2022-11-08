package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rewards {
    private static final int LOTTO_PRICE = 1000;
    private final List<Rank> rankList;
    private final double totalPrize;
    private final Map<Rank, Integer> countByRank;

    public Rewards(List<Rank> rankList) {
        this.rankList = rankList;
        this.totalPrize = calculateTotalPrize(rankList);
        this.countByRank = countTotalRank(rankList);
    }


    private static long calculateTotalPrize(final List<Rank> rankList) {
        return rankList.stream()
                .mapToLong(Rank::getWinningMoney)
                .sum();
    }

    private Map<Rank, Integer> countTotalRank(List<Rank> rankList) {
        return rankList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));
    }

    public int count(final Rank rank) {
        return this.countByRank.getOrDefault(rank, 0);
    }

    public double calculateRateReward() {
        double purchaseAmount = this.rankList.size() * LOTTO_PRICE;
        return totalPrize / purchaseAmount;
    }
}
