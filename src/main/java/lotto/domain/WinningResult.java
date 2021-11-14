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
        Optional.ofNullable(winningResultMap).orElseThrow(
                () -> new RuntimeException("보너스 번호가 존재하지 않습니다."));
        return winningResultMap;
    }

    public boolean isExist() {
        return !winningResultMap.isEmpty();
    }
}
