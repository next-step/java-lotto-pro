package lotto;

import lotto.money.Money;
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
        return results.getOrDefault(lottoPrize, 0);
    }

    public BigDecimal rateOfReturn(Money money) {
        return calculateTotalPrize().percentage(money);
    }

    private Money calculateTotalPrize() {
        Money totalPrize = Money.of(0);
        for (Map.Entry<LottoPrize, Integer> entry : results.entrySet()) {
            final LottoPrize lottoPrize = entry.getKey();
            final long count = entry.getValue().longValue();
            Money prize = lottoPrize.prize().multiple(count);
            totalPrize = totalPrize.add(prize);
        }
        return totalPrize;
    }
}
