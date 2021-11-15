package lotto.domain;

import lotto.consts.WinningEnum;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {

    private final Map<WinningEnum, Integer> winningStats;

    public WinningStats(Lottos lottos, Lotto winningLotto) {
        winningStats = new HashMap<>();
        winningStats.put(WinningEnum.FIRST, 0);
        winningStats.put(WinningEnum.THIRD, 0);
        winningStats.put(WinningEnum.FOURTH, 0);
        winningStats.put(WinningEnum.FIFTH, 0);

        for (Lotto lotto : lottos.getLottos()) {
            setResult(lotto.getWinningResult(winningLotto));
        }
    }

    private void setResult(WinningEnum result) {
        if (result != WinningEnum.NONE) {
            winningStats.put(result, winningStats.get(result) + 1);
        }
    }

    public Map<WinningEnum, Integer> getWinningStats() {
        return winningStats;
    }
}
