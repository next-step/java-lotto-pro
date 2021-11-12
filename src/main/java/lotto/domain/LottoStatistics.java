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

    public LottoRewardResult collectLottoRewardResult(LottoTickets lottoTickets) {
        Map<LottoTicket, Integer> winningCountResult = winningNumbers.checkWinningCount(lottoTickets);
        Map<LottoTicket, Boolean> containsBonusNumberResult = lottoTickets.checkContainsBonusNumber(bonusNumber);
        Map<LottoReward, Integer> lottoReward = collectLottoRewardCount(winningCountResult, containsBonusNumberResult);
        return new LottoRewardResult(lottoReward);
    }

    public double calculateRateOfProfit(LottoTickets lottoTickets, LottoRewardResult lottoRewardResult) {
        return lottoRewardResult.calculateRateOfProfit(lottoTickets.calculatePurchaseMoney());
    }

    private Map<LottoReward, Integer> collectLottoRewardCount(Map<LottoTicket, Integer> winningCountMap, Map<LottoTicket, Boolean> containsBonusNumberMap) {
        Map<LottoReward, Integer> lottoRewards = new HashMap<>();
        for (Map.Entry<LottoTicket, Integer> entry : winningCountMap.entrySet()) {
            LottoReward lottoReward = LottoReward.findLottoReward(entry.getValue(), containsBonusNumberMap.get(entry.getKey()));
            lottoRewards.put(lottoReward, lottoRewards.getOrDefault(lottoReward, 0) + 1);
        }
        return lottoRewards;
    }
}
