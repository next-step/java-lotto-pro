package nextstep.lotto.domain;

import java.math.BigDecimal;

public class PurchaseLottoAmount {

    private final Long purchaseLottoAmount;
    private final Long manualPurchaseLottoCount;

    public PurchaseLottoAmount(Long purchaseLottoAmount, Long manualPurchaseLottoCount) {
        this.purchaseLottoAmount = purchaseLottoAmount;
        this.manualPurchaseLottoCount = manualPurchaseLottoCount;
    }

    public Long calculateAutoLottoPurchaseCount(Long lottoPrice) {
        return purchaseLottoAmount / lottoPrice - manualPurchaseLottoCount;
    }

    public Long calculateManualLottoPurchaseCount(Long lottoPrice) {
        return manualPurchaseLottoCount;
    }

    public BigDecimal calculateReturnRate(Long totalWinningAmount) {
        BigDecimal total = new BigDecimal(totalWinningAmount);
        BigDecimal purchase = new BigDecimal(purchaseLottoAmount);

        return total.divide(purchase, 2, BigDecimal.ROUND_DOWN);
    }
}
