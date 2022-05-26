package lotto.view;

public class PurchaseHistory {
	private int autoCount;
	private int manualCount;

	public PurchaseHistory(int autoCount, int manualCount) {
		this.autoCount = autoCount;
		this.manualCount = manualCount;
	}

	public int getAutoCount() {
		return autoCount;
	}

	public int getManualCount() {
		return manualCount;
	}
}
