package lotto;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    private final Map<LottoPrize, Integer> results;

    protected WinningResult() {
        this(new EnumMap<>(LottoPrize.class));
    }

    protected WinningResult(Map<LottoPrize, Integer> results) {
        this.results = results;
    }

    public Integer find(LottoPrize lottoPrize) {
        return null;
    }

    public BigDecimal rateOfReturn() {
        return null;
    }
}
