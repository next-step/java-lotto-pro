package lotto;

import java.util.List;

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

    public long countByWinningResult(WinningResult winningResult) {
        return results.stream().filter(result -> result.equals(winningResult)).count();
    }

    public double calculateProfitRate() {
        long reward = MATCH_THREE_REWARD * countByWinningResult(WinningResult.MATCH_THREE)
                + MATCH_FOUR_REWARD * countByWinningResult(WinningResult.MATCH_FOUR)
                + MATCH_FIVE_REWARD * countByWinningResult(WinningResult.MATCH_FIVE)
                + MATCH_SIX_REWARD * countByWinningResult(WinningResult.MATCH_SIX);
        return reward / ((double) LOTTO_PRICE.getAmount() * results.size());
    }
}
