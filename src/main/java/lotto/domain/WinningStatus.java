package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningStatus {
    private static final long DEFAULT_WINNING_COUNT = 0L;
    private final Map<Rank, Long> value;

    public WinningStatus(List<Rank> ranks) {
        this.value = ranks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static WinningStatus from(List<Rank> ranks) {
        return new WinningStatus(ranks);
    }

    public long numberOfWinning(Rank rank) {
        return this.value.getOrDefault(rank, DEFAULT_WINNING_COUNT);
    }

    public Money getWinningReward() {
        return this.value.entrySet()
                .stream()
                .map(entry -> entry.getKey().getWinningReward(Math.toIntExact(entry.getValue())))
                .reduce(Money::plus)
                .get();
    }
}
