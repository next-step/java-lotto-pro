package lotto.model.purchase;

import lotto.model.money.Money;

public class PurchaseManualCount {

    private final int purchaseManualCount;

    public PurchaseManualCount(int purchaseManualCount, Money purchaseMoney) {
        if (purchaseManualCount < 0) {
            throw new IllegalArgumentException("구입금액은 0이상의 값이어야 합니다.");
        }
        if (purchaseMoney.possiblePurchaseLotto() < purchaseManualCount) {
            throw new IllegalArgumentException("구입금액을 초과하여 로또를 구매할 수 없습니다.");
        }

        this.purchaseManualCount = purchaseManualCount;
    }

    public int getPurchaseManualCount() {
        return purchaseManualCount;
    }

}
