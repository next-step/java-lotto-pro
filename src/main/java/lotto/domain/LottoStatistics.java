package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final WinningNumbers winningNumbers;

    public LottoStatistics(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoRewardResult getStatistics(LottoTickets lottoTickets) {
        Map<LottoTicket, Integer> winningCountMap = winningNumbers.getWinningCountMap(lottoTickets);
        Map<Integer, Integer> winningCountStatisticsMap = createWinningCountStatisticsMap(winningCountMap);
        return new LottoRewardResult(createLottoRewardStatisticsMap(winningCountStatisticsMap));
    }

    private Map<LottoReward, Integer> createLottoRewardStatisticsMap(Map<Integer, Integer> winningCountStatisticsMap) {
        Map<LottoReward, Integer> lottoRewardMap = new HashMap<>();
        for (int winningCount : winningCountStatisticsMap.keySet()) {
            checkWinningAndPutRewardMap(winningCountStatisticsMap, lottoRewardMap, winningCount);
        }
        return lottoRewardMap;
    }

    private void checkWinningAndPutRewardMap(Map<Integer, Integer> winningCountStatisticsMap, Map<LottoReward, Integer> lottoRewardMap, int winningCount) {
        if (LottoReward.isWinning(winningCount)) {
            LottoReward lottoReward = LottoReward.getLottoReward(winningCount);
            lottoRewardMap.put(lottoReward, winningCountStatisticsMap.get(winningCount));
        }
    }

    private Map<Integer, Integer> createWinningCountStatisticsMap(Map<LottoTicket, Integer> winningCountMap) {
        Map<Integer, Integer> countStatisticsMap = new HashMap<>();
        for (int count : winningCountMap.values()) {
            countStatisticsMap.put(count, countStatisticsMap.getOrDefault(count, 0) + 1);
        }
        return countStatisticsMap;
    }
}
