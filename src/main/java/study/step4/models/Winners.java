package study.step4.models;

import study.step4.Rank;

import java.util.*;

public class Winners {
    private final Map<Rank, Integer> winners;

    public Winners() {
        winners = new EnumMap<>(Rank.class);
    }

    public Winners(Map<Rank, Integer> winners) {
        this.winners = winners;
    }

    public int numberOfRankers(Rank rank) {
        return winners.get(rank);
    }

    public double earningRate(Money inputMoney) {
        return inputMoney.divide(totalReward());
    }

    private int totalReward() {
        int total = 0;
        for (Map.Entry<Rank, Integer> map : winners.entrySet()) {
            total += map.getKey().getReward() * map.getValue();
        }
        return total;
    }

    public void add(Rank rank) {
        winners.put(rank, winners.getOrDefault(rank, 0) + 1);
    }
}
