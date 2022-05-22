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
            Prize prizeOfRank = rank.getPrize();
            int count = rankCount.get(rank);
            totalPrize = totalPrize.add(prizeOfRank.multiply(count));
        }
        return totalPrize;
    }

    @Override
    public String toString() {
        List<Rank> rankList = new ArrayList<>(rankCount.keySet());
        rankList.sort(Comparator.naturalOrder());

        StringBuilder stringBuilder = new StringBuilder();
        rankList.forEach(rank -> {
            stringBuilder.append(rankCountStr(rank));
        });

        return stringBuilder.toString();
    }

    private String rankCountStr(Rank rank) {
        if (!rank.isOverMinWinningRank()) {
            return "";
        }
        return String.format(rank + "- %d개\n", rankCount.get(rank));
    }
}
