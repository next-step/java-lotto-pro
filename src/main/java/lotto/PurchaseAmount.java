package lotto;

public class PurchaseAmount {
	private static final String ERROR_PURCHASE_AMOUNT_TYPE = "[ERROR] 구매금액은 숫자만 입력가능합니다.";
	private final int purchaseAmount;

	public PurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = stringValueToIntValue(purchaseAmount);
	}

	public int value() {
		return purchaseAmount;
	}

	private int stringValueToIntValue(String purchaseAmount) {
		try {
			return Integer.parseInt(purchaseAmount);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_TYPE);
		}
	}
}
