package lotto.view.message.dto;

import lotto.domain.Money;
import lotto.domain.WinningStatistic;
import lotto.enums.Rank;

public class MatchResultParameters {

    private final int matchCount;
    private final Money prize;
    private final int statisticCount;

    public MatchResultParameters(Rank rank, WinningStatistic statistic) {
        this.matchCount = rank.matchingCount();
        this.prize = rank.prize();
        this.statisticCount = statistic.count(rank);
    }

    public int matchCount() {
        return matchCount;
    }

    public Money prize() {
        return prize;
    }

    public int statisticCount() {
        return statisticCount;
    }
}
