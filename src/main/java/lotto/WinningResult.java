package lotto;

import java.util.Map;
import java.util.Set;

public class WinningResult {

    private static final int THREE_MATCH_PRIZE_MONEY = 5000;
    private static final int FOUR_MATCH_PRIZE_MONEY = 50000;
    private static final int FIVE_MATCH_PRIZE_MONEY = 1500000;
    private static final int SIX_MATCH_PRIZE_MONEY = 2000000000;
    private Map<Integer, Integer> result;

    public WinningResult(Map<Integer, Integer> result) {
        winningRankValid(result);
        this.result = result;
    }

    private void winningRankValid(Map<Integer, Integer> result) {
        Set<Integer> winningNumberMatchCounts = result.keySet();
        for (Integer winningNumberMatchCount : winningNumberMatchCounts) {
            if (isNotWinningCheck(winningNumberMatchCount)) {
                result.remove(winningNumberMatchCount);
            }
        }
    }

    private boolean isNotWinningCheck(Integer winningNumberMatchCount) {
        return winningNumberMatchCount < LottoProperty.WINNING_ACKNOWLEDGEMENT_MINIMUM_MATCH_COUNT;
    }

    public int winnerPerWinningRank(int winningRank) {
        if (!isCorrectRank(winningRank)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_RANK_OUT_BOUND.getMessage());
        }
        return result.get(winningRank);
    }

    //TODO 질문3
    protected double profitRate(int purchaseAmount, int profitAmount) {
        return profitAmount / (double) purchaseAmount;
    }

    //TODO 질문3
    public double profitRate(int purchaseAmount) {
        return profitAmount() / (double) purchaseAmount;
    }

    //TODO 질문4
    public long profitAmount() {
        Set<Map.Entry<Integer, Integer>> resultEntrySet = this.result.entrySet();
        long profitAmount = 0L;

        for (Map.Entry<Integer, Integer> winningRanks : resultEntrySet) {
            Integer rank = winningRanks.getKey();
            Integer winningCount = winningRanks.getValue();

            if (rank == 3) {
                profitAmount += (long) THREE_MATCH_PRIZE_MONEY * winningCount;
            }

            if (rank == 4) {
                profitAmount += (long) FOUR_MATCH_PRIZE_MONEY * winningCount;
            }

            if (rank == 5) {
                profitAmount += (long) FIVE_MATCH_PRIZE_MONEY * winningCount;
            }

            if (rank == 6) {
                profitAmount += (long) SIX_MATCH_PRIZE_MONEY * winningCount;
            }
        }

        return profitAmount;
    }

    private boolean isCorrectRank(int winningNumber) {
        return winningNumber >= LottoProperty.WINNING_ACKNOWLEDGEMENT_MINIMUM_MATCH_COUNT && winningNumber <= LottoProperty.WINNING_ACKNOWLEDGEMENT_MAXIMUM_MATCH_COUNT;
    }
}
