package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResults {
    private final List<WinningResult> winningResult;

    public WinningResults(Lottos lottos) {
        this.winningResult = mapWinningRank(lottos);
    }

    private List<WinningResult> mapWinningRank(Lottos lottos) {
        List<WinningResult> winningRanks = new ArrayList<WinningResult>();
        List<WinningRank> ranks = WinningRank.createWinningRanks();
        for (WinningRank winningRank : ranks) {
            winningRanks.add(new WinningResult(winningRank, countWinningRank(winningRank, lottos)));
        }
        return winningRanks;
    }

    public List<WinningResult> getWinningResult() {
        return this.winningResult;
    }
    
    public double calculateRewardPercent(Money money) {
        int totalReward = winningResult.stream()
                .mapToInt(wr -> wr.getCount() * wr.getWinningRank().getReward())
                .sum();
        return totalReward / (double) money.getMoney();
    }
    
    private int countWinningRank(WinningRank winningRank, Lottos lottos) {
        return (int) lottos.getLottos()
                    .stream()
                    .filter(wr -> wr.getWinningRank().equals(winningRank))
                    .count();
    }

}
