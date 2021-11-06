package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResults {
    private final List<WinningResult> winningResult;

    public WinningResults(Lottos lottos) {
        this.winningResult = mapWinningRank(lottos);
    }

    private List<WinningResult> mapWinningRank(Lottos lottos) {
        List<WinningResult> winningRanks = new ArrayList<WinningResult>();
        List<WinningRank> ranks = WinningRank.createWinningRanks();
        Map<WinningRank, Integer> rankMap = new HashMap<WinningRank, Integer>();
        for (Lotto lotto : lottos.getLottos()) {
            rankMap.put(lotto.getWinningRank(), rankMap.getOrDefault(lotto.getWinningRank(), 0) + 1);
        }
        ranks.forEach((rank) -> winningRanks.add(new WinningResult(rank, rankMap.getOrDefault(rank,0))));
        return winningRanks;
    }

    public List<WinningResult> getWinningResult() {
        return this.winningResult;
    }

}
