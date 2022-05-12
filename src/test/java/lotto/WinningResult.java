package lotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    private final Map<LottoPrize, Integer> results;

    protected WinningResult() {
        final Map<LottoPrize, Integer> results = new EnumMap<>(LottoPrize.class);
        for (LottoPrize lottoPrize: LottoPrize.values()) {
            results.put(lottoPrize, 0);
        }
        this.results = results;
    }

    public static WinningResult init() {
        return new WinningResult();
    }

    public Integer find(LottoPrize lottoPrize) {
        return results.get(lottoPrize);
    }
}
