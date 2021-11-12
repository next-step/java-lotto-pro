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

    public PrizeMoney prizeMoneyStatistics() {
        Set<Map.Entry<Rank, Integer>> resultEntrySet = this.result.entrySet();
        PrizeMoney prizeMoney = null;

        for (Map.Entry<Rank, Integer> winningRanks : resultEntrySet) {
            Rank rank = winningRanks.getKey();
            Integer winningCount = winningRanks.getValue();

            prizeMoney = rank.getPrizeMoney();
            prizeMoney.prizeMoneyAccumulate(winningCount);
        }

        return prizeMoney;
    }
}
