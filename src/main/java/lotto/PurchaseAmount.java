package lotto;

public class PurchaseAmount {
	private static final String ERROR_PURCHASE_AMOUNT_TYPE = "[ERROR] 구매금액은 숫자만 입력가능합니다.";
	private final int purchaseAmount;

	public PurchaseAmount(String purchaseAmount) {
		validatePurchaseAmountType(purchaseAmount);
		this.purchaseAmount = Integer.parseInt(purchaseAmount);
	}

	public int value() {
		return purchaseAmount;
	}

	private void validatePurchaseAmountType(String purchaseAmount) {
		try {
			Integer.parseInt(purchaseAmount);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_TYPE);
		}
	}
}
