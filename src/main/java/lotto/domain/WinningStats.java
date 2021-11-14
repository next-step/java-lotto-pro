package lotto.domain;

import lotto.consts.WinningEnum;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {

    private final Map<Integer, Integer> winningStats;

    public WinningStats(Lottos lottos, WinningNumbers winningNumbers) {
        winningStats = new HashMap<>();
        winningStats.put(WinningEnum.FIRST.getRank(), 0);
        winningStats.put(WinningEnum.THIRD.getRank(), 0);
        winningStats.put(WinningEnum.FOURTH.getRank(), 0);
        winningStats.put(WinningEnum.FIFTH.getRank(), 0);

        for (Lotto lotto : lottos.getLottos()) {
            setResult(lotto.getWinningResult(winningNumbers));
        }
    }

    private void setResult(int result) {
        if (result != WinningEnum.NONE.getRank()) {
            winningStats.put(result, winningStats.get(result) + 1);
        }
    }

    public Map<Integer, Integer> getWinningStats() {
        return winningStats;
    }
}
