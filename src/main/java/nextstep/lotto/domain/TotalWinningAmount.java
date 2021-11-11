package nextstep.lotto.domain;

import java.math.BigDecimal;

public class TotalWinningAmount {

    private final Long totalWinningAmount;

    public TotalWinningAmount(MatchCountCollection matchCountCollection) {
        Long initialAmount = 0L;
        for (MatchCount matchCount : matchCountCollection) {
            initialAmount += matchCount.mulMatchCountAndPrice();
        }

        this.totalWinningAmount = initialAmount;
    }

    public BigDecimal calculateReturnRate(PurchaseLottoAmount purchaseLottoAmount) {
        return purchaseLottoAmount.calculateReturnRate(totalWinningAmount);
    }
}
