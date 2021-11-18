package lotto.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.enums.Rank;

public class Ranks {
    private static long totalReward;

    private final Map<Rank, Integer> ranks = new HashMap<Rank, Integer>() {{
        Rank.REWARDING_GROUP.forEach(rank -> put(rank, 0));
    }};

    Ranks() {
    }

    public void put(final Rank rank, final int correctCount) {
        this.ranks.computeIfPresent(rank, (ignore, count) -> count + correctCount);
    }

    public String getResults() {
        return Rank.REWARDING_GROUP.stream()
            .sorted(Comparator.reverseOrder())
            .map(this::getResultBy)
            .collect(Collectors.joining(System.lineSeparator()));
    }

    public String averageYield(final Money money) {
        accumulateRewards();
        return String.format("총 수익률은 %.2f입니다.", (double)totalReward / money.exchangeLottoPurchasableCount());
    }

    private String getResultBy(final Rank rank) {
        final int ranksCount = this.ranks.get(rank);

        return rank.message(ranksCount);
    }

    private void accumulateRewards() {
        this.ranks
            .forEach((rank, count) -> totalReward += rank.accumulateReward(count).exchangeLottoPurchasableCount());
    }
}
