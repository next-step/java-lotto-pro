package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final WinningNumbers winningNumbers;
    private final Number bonusNumber;

    public LottoStatistics(WinningNumbers winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRewardResult getLottoRewardResult(LottoTickets lottoTickets, Number bonusNumber) {
        Map<LottoTicket, Integer> winningCountMap = winningNumbers.getWinningCountMap(lottoTickets);
        Map<LottoTicket, Boolean> containsBonusNumberMap = lottoTickets.getContainsBonusNumberMap(bonusNumber);
        Map<LottoReward, Integer> lottoRewardMap = getLottoRewardMap(winningCountMap, containsBonusNumberMap);
        return new LottoRewardResult(lottoRewardMap);
    }

    public double getRateOfProfit(LottoTickets lottoTickets, LottoRewardResult lottoRewardResult) {
        return lottoRewardResult.getRateOfProfit(lottoTickets.getPurchaseMoney());
    }

    private Map<LottoReward, Integer> getLottoRewardMap(Map<LottoTicket, Integer> winningCountMap, Map<LottoTicket, Boolean> containsBonusNumberMap) {
        Map<LottoReward, Integer> lottoRewards = new HashMap<>();
        for (Map.Entry<LottoTicket, Integer> entry : winningCountMap.entrySet()) {
            LottoReward lottoReward = LottoReward.getLottoReward(entry.getValue(), containsBonusNumberMap.get(entry.getKey()));
            lottoRewards.put(lottoReward, lottoRewards.getOrDefault(lottoReward, 0) + 1);
        }
        return lottoRewards;
    }
}
