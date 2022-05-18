package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Earning {
    private final BigDecimal earningRate;

    private Earning(BigDecimal earningRate) {
        this.earningRate = earningRate;
    }

    public static Earning of(Prize totalPrize, Money purchaseAmount) {
        BigDecimal wrappedTotalPrize = BigDecimal.valueOf(totalPrize.getAmount());
        BigDecimal wrappedPurchaseAmount = BigDecimal.valueOf(purchaseAmount.getAmount());
        return new Earning(wrappedTotalPrize.divide(wrappedPurchaseAmount, 2, RoundingMode.FLOOR));
    }

    public BigDecimal getEarningRate() {
        return earningRate;
    }
}
