package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRewardResult {

    private Map<LottoReward, Integer> lottoRewardMap = new HashMap<>();

    public LottoRewardResult(Map<LottoReward, Integer> lottoRewardMap) {
        this.lottoRewardMap = lottoRewardMap;
    }

    public double calculateRateOfProfit(int purchaseMoney) {
        long profitMoney = 0;
        for (LottoReward lottoReward : lottoRewardMap.keySet()) {
            profitMoney += lottoReward.getRewardMoney() * lottoRewardMap.get(lottoReward);
        }
        return (double) profitMoney / purchaseMoney;
    }

    public int findWinningLottoTicketCount(LottoReward lottoReward) {
        return lottoRewardMap.getOrDefault(lottoReward, 0);
    }

    public Map<LottoReward, Integer> getLottoRewardMap() {
        return lottoRewardMap;
    }
}
