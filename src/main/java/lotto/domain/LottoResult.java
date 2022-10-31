package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    Map<RewardType, Integer> rewardMap = new HashMap<>();
    int totalReward;
    double totalProfit;
    public LottoResult(Lottos lottos, Lotto winLotto) {
        calculateWinCount(lottos, winLotto);
        calculateTotalReward();
        calculateProfit(lottos.size());
    }

    private void calculateProfit(int lottoSize) {
        totalProfit = totalReward / (lottoSize * LOTTO_PRICE);
    }

    private void calculateTotalReward() {
        for (RewardType reward : RewardType.values()) {
            totalReward += rewardMap.getOrDefault(reward,0) * reward.getRewardPrice();
        }
    }

    private void calculateWinCount(Lottos lottos, Lotto winLotto) {
        for (Lotto lotto : lottos) {
            RewardType rewardType = RewardType.match(lotto, winLotto);
            rewardMap.put(rewardType, rewardMap.getOrDefault(rewardType, 0) + 1);
        }
    }

    public int getRewardMapCount(RewardType type) {
        return rewardMap.getOrDefault(type, 0);
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
