package lotto.domain;

public class PurchaseAmount {
	private static final String ERROR_PURCHASE_AMOUNT_TYPE = "[ERROR] 구매금액은 숫자만 입력가능합니다.";
	private static final String ERROR_PURCHASE_AMOUNT = "[ERROR] 구매금액은 최소 1000원 이상입니다.";
	private static final int LOTTO_PRICE = 1000;
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
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_TYPE);
		}
	}

	private int validatePurchaseAmount(int purchaseAmount) {
		if (purchaseAmount < LOTTO_PRICE) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT);
		}
		return purchaseAmount;

	}

	public int purchase() {
		return purchaseAmount / LOTTO_PRICE;
	}
}
