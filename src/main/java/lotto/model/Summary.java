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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Objects.equals(ranks, summary.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }

    @Override
    public String toString() {
        return "Summary{" +
                "ranks=" + ranks +
                '}';
    }
}
