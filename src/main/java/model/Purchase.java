package model;

public class Purchase {
	private PurchaseCount autoCount;

	private Manual manual;

	public Manual getManual() {
		return manual;
	}

	public PurchaseCount getManualCount() {
		return manual.getCount();
	}

	public Lottos getManualLottos() {
		return manual.getLottos();
	}

	public PurchaseCount getAutoCount() {
		return autoCount;
	}
}
