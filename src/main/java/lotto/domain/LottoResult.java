package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    Map<Rank, Integer> rewardMap = new HashMap<>();
    int totalReward;
    double totalProfit;
    public LottoResult(Lottos lottos, Lotto winLotto, int totalLottoPrice, LottoNumber bonus) {
        calculateWinCount(lottos, winLotto, bonus);
        calculateTotalReward();
        calculateProfit(totalLottoPrice);
    }

    private void calculateProfit(int totalLottoPrice) {
        totalProfit = (double) totalReward / totalLottoPrice;
    }

    private void calculateTotalReward() {
        for (Rank reward : Rank.values()) {
            totalReward += rewardMap.getOrDefault(reward,0) * reward.getWinningMoney();
        }
    }

    private void calculateWinCount(Lottos lottos, Lotto winLotto, LottoNumber bonus) {
        rewardMap = Lottos.calculateWinResult(lottos, winLotto, bonus);
    }

    public int getRewardMapCount(Rank type) {
        return rewardMap.getOrDefault(type, 0);
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
