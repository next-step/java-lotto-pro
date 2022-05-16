package lotto.domain;

public class LottoPurchase {
    private final static int LOTTO_PURCHASE_PRICE_VALUE = 1000;

    public static final String ERROR_INVALID_PURCHASE_PRICE_MESSAGE = "[ERROR] 숫자만 입력가능합니다.";
    public static final String ERROR_NEGATIVE_PURCHASE_PRICE_MESSAGE = "[ERROR] 양수만 입력가능합니다.";
    public static final String ERROR_UNIT_PURCHASE_PRICE_MESSAGE = "[ERROR] 1,000원 단위로 입력가능합니다.";

    private final int purchasePrice;

    public LottoPurchase(String purchasePriceText) {
        this.purchasePrice = parsePurchasePrice(purchasePriceText);
    }

    private int parsePurchasePrice(String purchasePriceText) {
        int parsingPurchasePrice;
        try {
            parsingPurchasePrice = Integer.parseInt(purchasePriceText);
            checkValidationPurchasePrice(parsingPurchasePrice);
            return parsingPurchasePrice;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_PRICE_MESSAGE);
        }
    }

    private void checkValidationPurchasePrice(int purchasePrice) {
        if (isNegative(purchasePrice))
            throw new IllegalArgumentException(ERROR_NEGATIVE_PURCHASE_PRICE_MESSAGE);

        if (purchasePrice % LOTTO_PURCHASE_PRICE_VALUE != 0)
            throw new IllegalArgumentException(ERROR_UNIT_PURCHASE_PRICE_MESSAGE);
    }

    public int purchaseCount() {
        return this.purchasePrice / LOTTO_PURCHASE_PRICE_VALUE;
    }

    private boolean isNegative(int purchasePrice) {
        return purchasePrice < 0;
    }
}
