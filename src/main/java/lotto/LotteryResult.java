package lotto;

import java.util.Map;

import static lotto.Rank.*;

public class LotteryResult {
    private final Map<Rank, Integer> results;

    public LotteryResult(Map<Rank, Integer> results) {
        this.results = results;
    }

    public static LotteryResult saveLotteryResult(Map<Rank, Integer> results) {
        return new LotteryResult(results);
    }

    public int getOrDefault(Rank rank, int defaultValue) {
        return results.getOrDefault(rank, defaultValue);
    }

    public int calculateTotalWinningMoney() {
        return results.getOrDefault(FIFTH, 0) * FIFTH.getWinningMoney()
                + results.getOrDefault(FOURTH, 0) * FOURTH.getWinningMoney()
                + results.getOrDefault(THIRD, 0) * THIRD.getWinningMoney()
                + results.getOrDefault(SECOND, 0) * SECOND.getWinningMoney()
                + results.getOrDefault(FIRST, 0) * FIRST.getWinningMoney();
    }
}
