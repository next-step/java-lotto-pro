package lotto.model.dto;

import lotto.model.constants.ErrorMessage;

public class PurchaseAmount {

    private long purchaseAmount;

    public PurchaseAmount(String input) {
        try {
            this.purchaseAmount = Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER);
        }
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }
}
