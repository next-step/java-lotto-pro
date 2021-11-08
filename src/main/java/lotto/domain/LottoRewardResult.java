package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRewardResult {

    private Map<LottoReward, Integer> lottoRewardMap = new HashMap<>();

    public LottoRewardResult(Map<LottoReward, Integer> lottoRewardMap) {
        this.lottoRewardMap = lottoRewardMap;
    }

    public Map<LottoReward, Integer> getLottoRewardMap() {
        return lottoRewardMap;
    }

    public double getRateOfProfit(int purchaseMoney) {
        long profitMoney = 0;
        for (LottoReward lottoReward : lottoRewardMap.keySet()) {
            profitMoney += lottoReward.getRewardMoney() * lottoRewardMap.get(lottoReward);
        }
        return (double) profitMoney / purchaseMoney;
    }

    public int getWinningLottoTicketCount(LottoReward lottoReward) {
        return lottoRewardMap.getOrDefault(lottoReward, 0);
    }
}
