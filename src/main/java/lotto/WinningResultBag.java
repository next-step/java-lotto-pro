package lotto;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.LottoBag.LOTTO_PRICE;

public class WinningResultBag {

    public static final int MATCH_THREE_REWARD = 5000;
    public static final int MATCH_FOUR_REWARD = 50000;
    public static final int MATCH_FIVE_REWARD = 1500000;
    public static final int MATCH_SIX_REWARD = 2000000000;
    private final List<WinningResult> results;

    public WinningResultBag(List<WinningResult> results) {
        this.results = results;
    }

    public Map<WinningResult, Long> groupByWinningResult() {
        return results.stream().collect(groupingBy(it -> it, counting()));
    }

    public double calculateProfitRate() {
        Map<WinningResult, Long> winningResultMap = groupByWinningResult();
        long reward = MATCH_THREE_REWARD * winningResultMap.get(WinningResult.MATCH_THREE)
                + MATCH_FOUR_REWARD * winningResultMap.get(WinningResult.MATCH_FOUR)
                + MATCH_FIVE_REWARD * winningResultMap.get(WinningResult.MATCH_FIVE)
                + MATCH_SIX_REWARD * winningResultMap.get(WinningResult.MATCH_SIX);
        return reward / ((double) LOTTO_PRICE.getAmount() * results.size());
    }
}
