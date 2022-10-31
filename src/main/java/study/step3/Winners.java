package study.step3;

import java.util.List;

public class Winners {
    private final List<Lotto> winners;

    public Winners(List<Lotto> winners) {
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
                .mapToInt(Lotto::reward)
                .sum();
    }
}
