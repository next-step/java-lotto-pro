package lotto;

import java.util.Map;
import java.util.Set;

public class WinningResult {

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

    private boolean isCorrectRank(int winningNumber) {
        return winningNumber >= LottoProperty.WINNING_ACKNOWLEDGEMENT_MINIMUM_MATCH_COUNT && winningNumber <= LottoProperty.WINNING_ACKNOWLEDGEMENT_MAXIMUM_MATCH_COUNT;
    }
}
