package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final List<WinningStatistic> winningStatistic;

    public WinningStatistics(Lottos lottos) {
        this.winningStatistic = mapWinningRank(lottos);
    }

    private List<WinningStatistic> mapWinningRank(Lottos lottos) {
        List<WinningStatistic> winningRanks = new ArrayList<WinningStatistic>();
        List<Lotto> lottoList = lottos.getLottos();
        List<WinningRank> ranks = WinningRank.createWinningRanks();
        Map<WinningRank, Integer> rankMap = new HashMap<WinningRank, Integer>();
        for (Lotto lotto : lottoList) {
            rankMap.put(lotto.getWinningRank(), rankMap.getOrDefault(lotto.getWinningRank(), 0) + 1);
        }
        ranks.forEach((rank) -> winningRanks.add(new WinningStatistic(rank, rankMap.getOrDefault(rank,0))));
        return winningRanks;
    }

    public List<WinningStatistic> getWinningStatistic() {
        return this.winningStatistic;
    }

}
