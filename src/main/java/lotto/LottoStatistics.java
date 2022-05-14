package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final List<WinningRank> winningRanks;

    public LottoStatistics(List<WinningRank> winningRanks) {
        this.winningRanks = winningRanks;
    }

    public Map<WinningRank, Integer> getCountByWinningRank() {
        EnumMap<WinningRank, Integer> result = new EnumMap<>(WinningRank.class);

        for (WinningRank winningRank : winningRanks) {
            Integer count = result.getOrDefault(winningRank, 0);
            result.put(winningRank, count + 1);
        }

        return result;
    }
}
