package model;

public class LottoPurchaseCount {
	public static final int LOTTO_PRICE = 1000;
	public static final String MESSAGE_PRICE_MUST_BE_LARGER_THAN_ZERO = "PRICE_MUST_BE_LARGER_THAN_ZERO";

	private final int purchaseCount;

	public LottoPurchaseCount(String purchasePriceString) {
		int purchaseCount = Integer.parseInt(purchasePriceString) / LOTTO_PRICE;
		if (purchaseCount == 0) {
			throw new IllegalArgumentException(MESSAGE_PRICE_MUST_BE_LARGER_THAN_ZERO);
		}
		this.purchaseCount = purchaseCount;
	}

	public int get() {
		return purchaseCount;
	}

	public int getTotalPrice() {
		return purchaseCount * LOTTO_PRICE;
	}
}
