package lotto.domain;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1_000;
    private static final String INVALID_PURCHASE_AMOUNT = "로또는 1장에 1000원입니다. 구입금액을 다시 입력해주세요.";
    private int purchaseAmount;
    private int purchaseQuantity;
    private int autoPurchaseQuantity;
    private int manualPurchaseQuantity;

    private LottoPurchase() {
    }

    public LottoPurchase(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.purchaseQuantity = calculatePurchaseQuantity();
        this.autoPurchaseQuantity = this.purchaseQuantity;
    }

    public void buyManual(int inputManualPurchaseQuantity) {
        this.autoPurchaseQuantity = purchaseQuantity - inputManualPurchaseQuantity;
        this.manualPurchaseQuantity = inputManualPurchaseQuantity;
    }

    private int calculatePurchaseQuantity() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public int getAutoPurchaseQuantity() {
        return autoPurchaseQuantity;
    }

    public int getManualPurchaseQuantity() {
        return manualPurchaseQuantity;
    }

}
