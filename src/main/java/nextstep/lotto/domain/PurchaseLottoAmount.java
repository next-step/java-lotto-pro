package nextstep.lotto.domain;

import java.math.BigDecimal;

public class PurchaseLottoAmount {

    private final Long purchaseLottoAmount;

    public PurchaseLottoAmount(Long purchaseLottoAmount) {
        this.purchaseLottoAmount = purchaseLottoAmount;
    }

    public Long calculateLottoPurchaseCount(Long lottoPrice) {
        return purchaseLottoAmount / lottoPrice;
    }

    public BigDecimal calculateReturnRate(Long totalWinningAmount) {
        BigDecimal total = new BigDecimal(totalWinningAmount);
        BigDecimal purchase = new BigDecimal(purchaseLottoAmount);

        return total.divide(purchase, 2);
    }
}
