package study.step4.models;

import study.step4.Rank;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Winner> winners;

    public Winners() {
        winners = new ArrayList<>();
    }

    public Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public int numberOfRankers(Rank rank) {
        return (int) winners.stream()
                .filter(winner -> winner.isSameRank(rank))
                .count();
    }

    public double earningRate(Money inputMoney) {
        return inputMoney.divide(totalReward());
    }

    private int totalReward() {
        return winners.stream()
                .mapToInt(Winner::reward)
                .sum();
    }

    public void add(Winner winner) {
        winners.add(winner);
    }
}
