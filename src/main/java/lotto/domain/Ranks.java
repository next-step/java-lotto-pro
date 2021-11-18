package lotto.domain;

import static java.text.MessageFormat.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import lotto.enums.Rank;

public class Ranks {
    private static long totalReward;

    private final Map<Rank, Integer> ranks = new HashMap<Rank, Integer>() {{
        put(Rank.FIRST_PLACE, 0);
        put(Rank.SECOND_PLACE, 0);
        put(Rank.THIRD_PLACE, 0);
        put(Rank.FORTH_PLACE, 0);
    }};

    Ranks() {
    }

    public void put(final Rank rank, final int correctCount) {
        this.ranks.computeIfPresent(rank, (ignore, count) -> count + correctCount);
    }

    public String getResults() {
        return new StringJoiner(System.lineSeparator())
            .add(getResultBy(Rank.FORTH_PLACE))
            .add(getResultBy(Rank.THIRD_PLACE))
            .add(getResultBy(Rank.SECOND_PLACE))
            .add(getResultBy(Rank.FIRST_PLACE))
            .toString();
    }

    public String averageYield(final Money money) {
        accumulateRewards();
        return String.format("총 수익률은 %.2f입니다.", (double)totalReward / money.exchangeLottoPurchasableCount());
    }

    private String getResultBy(final Rank rank) {
        final int ranksCount = this.ranks.get(rank);

        return new StringJoiner("- ")
            .add(rank.message())
            .add(format("{0}개", ranksCount))
            .toString();
    }

    private void accumulateRewards() {
        this.ranks
            .forEach((rank, count) -> totalReward += rank.accumulateReward(count).exchangeLottoPurchasableCount());
    }
}
