package lotto.domain;

import java.util.Map;
import java.util.Optional;

public class WinningResult {
    private Map<LottoPrize, Integer> winningResultMap;

    public WinningResult(Map<LottoPrize, Integer> winningResultMap) {
        this.winningResultMap = winningResultMap;
    }

    public int calculateWinningMoney() {
        int winningMoney = 0;
        for (LottoPrize lottoPrize : winningResultMap.keySet()) {
            winningMoney += lottoPrize.getMoney() * winningResultMap.get(lottoPrize);
        }
        return winningMoney;
    }

    public Map<LottoPrize, Integer> getValue() {
        return winningResultMap;
    }

    public boolean isExist() {
        return !winningResultMap.isEmpty();
    }
}
