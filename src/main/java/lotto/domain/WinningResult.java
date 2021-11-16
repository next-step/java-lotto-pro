package lotto.domain;

import java.util.Map;
import java.util.Set;

public class WinningResult {

    private Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public int winnerPerRank(Rank winningRank) {
        Integer winnerPerRank = result.get(winningRank);
        if (winnerPerRank == null) {
            return 0;
        }
        return winnerPerRank;
    }

    public Money prizeMoneyStatistics() {
        Set<Map.Entry<Rank, Integer>> resultEntrySet = this.result.entrySet();
        Money accumulatePrizeMoney = new Money(0);

        for (Map.Entry<Rank, Integer> winningRanks : resultEntrySet) {
            Rank rank = winningRanks.getKey();
            Integer winningCount = winningRanks.getValue();

            long rankPrizeMoney = rank.getPrizeMoney().getAmount();
            accumulatePrizeMoney.add(rankPrizeMoney * winningCount);
        }

        return accumulatePrizeMoney;
    }
}
