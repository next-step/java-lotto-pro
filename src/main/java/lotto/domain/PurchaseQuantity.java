package lotto.domain;

import java.util.Objects;
import util.ValidationUtil;

public class PurchaseQuantity {
    private static final String ERROR_MESSAGE_PURCHASE_MONEY_NULL = "[ERROR] 구매금액 관련 입력변수가 비었습니다.";
    private static final String ERROR_MESSAGE_MANUAL_QUANTITY_NEGATIVE = "[ERROR] 구매수량은 0 보다 작을 수 없습니다.";
    private static final String ERROR_MESSAGE_MANUAL_QUANTITY_OVER_TOTAL = "[ERROR] 수동 구매수량은 총 구매수량을 넘을 수 없습니다.";

    private final int totalQuantity;
    private final int manualQuantity;
    private final int autoQuantity;

    public PurchaseQuantity(PurchaseMoney purchaseMoney, int manualQuantity) {
        validate(purchaseMoney, manualQuantity);

        this.totalQuantity = purchaseMoney.getPurchasableQuantity();
        this.manualQuantity = manualQuantity;
        this.autoQuantity = this.totalQuantity - this.manualQuantity;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }

    public int getAutoQuantity() {
        return autoQuantity;
    }

    private void validate(PurchaseMoney purchaseMoney, int manualQuantity) {
        ValidationUtil.validateCorrectArguments(Objects.isNull(purchaseMoney), ERROR_MESSAGE_PURCHASE_MONEY_NULL);
        ValidationUtil.validateCorrectArguments(manualQuantity < 0, ERROR_MESSAGE_MANUAL_QUANTITY_NEGATIVE);
        ValidationUtil.validateCorrectArguments(manualQuantity > purchaseMoney.getPurchasableQuantity(),
                ERROR_MESSAGE_MANUAL_QUANTITY_OVER_TOTAL);
    }
}
