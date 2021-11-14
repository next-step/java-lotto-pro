package lotto.domain;

public class LottoManual {

    private final int purchaseCount;

    public LottoManual(final int lottoManualPurchaseCount, final Money money) {
        if (money.divide() - lottoManualPurchaseCount < 0) {
            throw new IllegalArgumentException("수동으로 구매하는 로또 수는 로또 구입금액을 초과할 수 없습니다.");
        }
        this.purchaseCount = lottoManualPurchaseCount;
    }
}
