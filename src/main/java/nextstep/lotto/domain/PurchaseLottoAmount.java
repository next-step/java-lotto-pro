package nextstep.lotto.domain;

public class PurchaseLottoAmount {

    private final Integer purchaseLottoAmount;

    public PurchaseLottoAmount(Integer purchaseLottoAmount) {
        this.purchaseLottoAmount = purchaseLottoAmount;
    }

    public Integer calculateLottoPurchaseCount(Integer lottoPrice) {
        return purchaseLottoAmount / lottoPrice;
    }
}
