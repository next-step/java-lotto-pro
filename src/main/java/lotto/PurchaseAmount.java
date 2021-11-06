package lotto;

public class PurchaseAmount {
	private final int purchaseAmount;

	public PurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = validatePurchaseAmount(stringValueToIntValue(purchaseAmount));
	}

	public int value() {
		return purchaseAmount;
	}

	private int stringValueToIntValue(String purchaseAmount) {
		try {
			return Integer.parseInt(purchaseAmount);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(CommonMessage.ERROR_PURCHASE_AMOUNT_TYPE);
		}
	}

	private int validatePurchaseAmount(int purchaseAmount) {
		if (purchaseAmount < CommonConstant.LOTTO_SALES_PRICE) {
			throw new IllegalStateException(CommonMessage.ERROR_PURCHASE_AMOUNT);
		}
		return purchaseAmount;

	}
}
