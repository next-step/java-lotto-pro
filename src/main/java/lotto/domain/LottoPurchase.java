package lotto.domain;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1_000;
    private static final String INVALID_PURCHASE_AMOUNT = "로또는 1장에 1000원입니다. 구입금액을 다시 입력해주세요.";
    private long purchaseAmount;
    private LottoPurchaseQuantity purchaseQuantity;

    private LottoPurchase() {
    }

    public LottoPurchase(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.purchaseQuantity = new LottoPurchaseQuantity();
        initPurchaseQuantity();
    }

    private void initPurchaseQuantity() {
        purchaseQuantity.addPurchaseQuantity(LottoPurchaseType.ALL, calculateAllQuantity());
        purchaseQuantity.addPurchaseQuantity(LottoPurchaseType.AUTO, calculateAllQuantity());
    }

    public void buyManualQuantity(int inputManualPurchaseQuantity) {
        purchaseQuantity.addPurchaseQuantity(LottoPurchaseType.MANUAL, inputManualPurchaseQuantity);
        purchaseQuantity.addPurchaseQuantity(LottoPurchaseType.AUTO, calculateAutoQuantity(inputManualPurchaseQuantity));
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public int findPurchaseQuantity(LottoPurchaseType lottoPurchaseType) {
        return purchaseQuantity.findPurchaseQuantity(lottoPurchaseType);
    }

    private int calculateAllQuantity() {
        return (int) (purchaseAmount / LOTTO_PRICE);
    }

    private int calculateAutoQuantity(int inputManualPurchaseQuantity) {
        return (int) ((purchaseAmount / LOTTO_PRICE) - inputManualPurchaseQuantity);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }

}
