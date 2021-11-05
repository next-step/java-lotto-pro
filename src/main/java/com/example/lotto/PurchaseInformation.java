package com.example.lotto;

public class PurchaseInformation {
	private final long purchaseMoney;
	private final long manualLottoPurchaseCount;
	private final long autoLottoPurchaseCount;
	private final long change;

	private PurchaseInformation(
		long purchaseMoney,
		long manualLottoPurchaseCount,
		long autoLottoPurchaseCount,
		long change
	) {
		this.purchaseMoney = purchaseMoney;
		this.manualLottoPurchaseCount = manualLottoPurchaseCount;
		this.autoLottoPurchaseCount = autoLottoPurchaseCount;
		this.change = change;
	}

	static PurchaseInformation of(int pricePerGame, long purchaseMoney, long manualLottoPurchaseCount) {
		if (isGreaterThan(pricePerGame * manualLottoPurchaseCount, purchaseMoney)) {
			String message = String.format("구입 금액보다 더 많은 로또를 구매할 수 없습니다. 구매금액=%d, 수동로또수=%d",
				purchaseMoney, manualLottoPurchaseCount);
			throw new IllegalArgumentException(message);
		}

		long autoLottoPurchaseCount = (purchaseMoney - manualLottoPurchaseCount * pricePerGame) / pricePerGame;
		long change = purchaseMoney - (manualLottoPurchaseCount + autoLottoPurchaseCount) * pricePerGame;

		return new PurchaseInformation(purchaseMoney, manualLottoPurchaseCount, autoLottoPurchaseCount, change);
	}

	private static boolean isGreaterThan(long first, long second) {
		return first > second;
	}

	public long getPurchaseMoney() {
		return purchaseMoney;
	}

	public long getManualLottoPurchaseCount() {
		return manualLottoPurchaseCount;
	}

	public long getAutoLottoPurchaseCount() {
		return autoLottoPurchaseCount;
	}

	public long getChange() {
		return change;
	}

	public long getActualPurchaseMoney() {
		return purchaseMoney - change;
	}
}
