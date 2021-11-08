package model;

public class LottoPurchaseCount {
	private final int purchaseCount;

	public LottoPurchaseCount(String purchaseCountString) {
		this.purchaseCount = Integer.parseInt(purchaseCountString);
	}

	public int get() {
		return purchaseCount;
	}
}
