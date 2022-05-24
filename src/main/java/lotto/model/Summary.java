package lotto.model;

import java.util.*;

public class Summary {
    private final Map<Rank, Integer> ranks;

    public Summary(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public List<String> winningDetails() {
        List<String> details = new LinkedList<>();
        for (Map.Entry<Rank, Integer> rank : this.ranks.entrySet()) {
            details.add(rank.getKey().detail(rank.getValue()));
        }
        return details;
    }

    public long totalPrizeMoney() {
        long sum = 0;
        for (Map.Entry<Rank, Integer> rank : this.ranks.entrySet()) {
            sum += (long) rank.getKey().prize() * rank.getValue();
        }
        return sum;
    }
}
