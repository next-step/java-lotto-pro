package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottosWinnerCounts {
    private final Map<LottoWinner, Integer> results = new HashMap<>();

    public LottosWinnerCounts(List<LottoWinner> winners) {
        initResults();
        reflectLottoWinner(winners);
    }

    private void initResults() {
        for (LottoWinner winner : LottoWinner.values()) {
            results.put(winner, 0);
        }
    }

    private void reflectLottoWinner(List<LottoWinner> lottoWinners) {
        for (LottoWinner winner : lottoWinners) {
            Integer winnerCount = results.get(winner);
            results.put(winner, winnerCount + 1);
        }
    }

    public int winnerCount(LottoWinner lottoWinner) {
        return results.get(lottoWinner);
    }
}
