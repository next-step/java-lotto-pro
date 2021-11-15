package lotto;

import java.util.Arrays;
import java.util.Map;

import static lotto.Rank.*;

public class LotteryResult {
    private final Map<Rank, Integer> results;

    private LotteryResult(Map<Rank, Integer> results) {
        this.results = results;
    }

    public static LotteryResult saveLotteryResult(Map<Rank, Integer> results) {
        return new LotteryResult(results);
    }

    public int getOrDefault(Rank rank, int defaultValue) {
        return results.getOrDefault(rank, defaultValue);
    }

    public int calculateTotalWinningMoney() {
        return Arrays.stream(values())
                .mapToInt(value -> results.getOrDefault(value, 0) * value.getWinningMoney()).sum();
    }
}
