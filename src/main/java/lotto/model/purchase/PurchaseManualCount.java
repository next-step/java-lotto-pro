package lotto.model.purchase;

import lotto.model.money.Money;

public class PurchaseManualCount {

    private final int purchaseManualCount;

    public PurchaseManualCount(String purchaseManualCount, Money purchaseMoney) {
        int manualCount = Integer.parseInt(purchaseManualCount);

        if (purchaseMoney.possiblePurchaseLotto() < manualCount) {
            throw new IllegalArgumentException("구입금액을 초과하여 로또를 구매할 수 없습니다.");
        }

        this.purchaseManualCount = manualCount;
    }

    public int getPurchaseManualCount() {
        return purchaseManualCount;
    }

}
