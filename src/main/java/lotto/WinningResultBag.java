package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.LottoBag.LOTTO_PRICE;

public class WinningResultBag {
    private final List<WinningResult> results;

    public WinningResultBag(List<WinningResult> results) {
        this.results = results;
    }

    public Map<WinningResult, Long> groupByWinningResult() {
        return results.stream().collect(groupingBy(it -> it, counting()));
    }

    public double calculateProfitRate() {
        Map<WinningResult, Long> winningResultMap = groupByWinningResult();
        long reward = Arrays.stream(WinningResult.values())
                .filter(winningResult -> winningResultMap.get(winningResult) != null)
                .mapToLong(winningResult -> winningResult.resultPrice(winningResultMap.get(winningResult)))
                .sum();
        return reward / ((double) LOTTO_PRICE.getAmount() * results.size());
    }
}
