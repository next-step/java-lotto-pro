package step3.domain;

public class PurchaseAmount {
    private static final int LOTTO_TICKET_PRICE = 1000;
    public static final String EXCEPTION_MESSAGE_FOR_MINIMUM_PURCHASE_AMOUNT = "최소 구입 가능 금액은 " + LOTTO_TICKET_PRICE + "원 입니다";
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_MINIMUM_PURCHASE_AMOUNT);
        }
    }
}
