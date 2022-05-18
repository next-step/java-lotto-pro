package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottosWinnerCounts {
    private final Map<LottoWinner, Integer> results = new HashMap<>();

    public LottosWinnerCounts() {
        initResults();
    }

    private void initResults() {
        for (LottoWinner winner : LottoWinner.values()) {
            results.put(winner, 0);
        }
    }

    public void reflectResult(LottoWinner lottoWinner) {
        Integer winnerCount = results.get(lottoWinner);
        results.put(lottoWinner, winnerCount + 1);
    }

    public int winnerCount(LottoWinner lottoWinner) {
        return results.get(lottoWinner);
    }
}
