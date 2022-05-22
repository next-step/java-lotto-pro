package lotto.model;

import java.util.*;

public class Summary {
    private final Map<Rank, Integer> ranks;

    public Summary(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public void printWinningDetails() {
        for (Map.Entry<Rank, Integer> rank : this.ranks.entrySet()) {
            System.out.println(rank.getKey().payPrize(rank.getValue()));
        }
    }

    public long totalPrizeMoney() {
        long sum = 0;
        for (Map.Entry<Rank, Integer> rank : this.ranks.entrySet()) {
            sum += (long) rank.getKey().prize() * rank.getValue();
        }
        return sum;
    }
}
