package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
    private final List<WinningRank> winningRanks;

    public WinningStatistics(Lottos lottos) {
        this.winningRanks = mapWinningRank(lottos);
    }

    private List<WinningRank> mapWinningRank(Lottos lottos) {
        List<WinningRank> winningRanks = new ArrayList<WinningRank>();
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            winningRanks.add(lotto.getResult());
        }
        return winningRanks;
    }

    public List<WinningRank> getWinningRanks() {
        return this.winningRanks;
    }

}
