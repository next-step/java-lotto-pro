package model;

public class LottoPurchaseCount {
	public static final int LOTTO_PRICE = 1000;

	private final int purchaseCount;

	public LottoPurchaseCount(String purchasePriceString) {
		this.purchaseCount = Integer.parseInt(purchasePriceString) / LOTTO_PRICE;
	}

	public int get() {
		return purchaseCount;
	}

	public int getTotalPrice() {
		return purchaseCount * LOTTO_PRICE;
	}
}
