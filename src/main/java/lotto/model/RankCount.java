package lotto.model;

import lotto.enums.Rank;

import java.util.*;

public class RankCount {
    private final Map<Rank, Integer> rankCount;

    private RankCount(Map<Rank, Integer> rankCount) {
        this.rankCount = rankCount;
    }

    public static RankCount from(Map<Rank, Integer> rankCount) {
        return new RankCount(rankCount);
    }

    public int getCount(Rank rank) {
        return rankCount.get(rank);
    }

    public Earning earningRate(Purchase purchase) {
        return Earning.of(totalPrize(), purchase.getPurchaseAmount());
    }

    private Prize totalPrize() {
        Prize totalPrize = Prize.of(0);
        for (Rank rank : rankCount.keySet()) {
            int count = rankCount.get(rank);
            Prize prizeOfRank = rank.getPrizeWithCount(count);
            totalPrize = totalPrize.add(prizeOfRank);
        }
        return totalPrize;
    }
}
