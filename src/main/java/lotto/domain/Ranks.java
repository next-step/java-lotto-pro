package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public Statistics makeStatistics() {
        Map<Rank, Long> rankCounts = ranks.stream()
            .collect(groupingBy(Function.identity(), counting()));

        EarningRate earningRate = Money.calculateEarningRate(
            ranks.stream().map(Rank::getMoney).collect(toList()));

        return new Statistics(rankCounts, earningRate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ranks)) {
            return false;
        }
        Ranks that = (Ranks)o;
        return Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
