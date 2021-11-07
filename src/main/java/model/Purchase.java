package model;

public class Purchase {
	private PurchaseCount autoCount;

	private Manual manual;

	public Purchase(PurchaseCount autoCount, Manual manual) {
		this.autoCount = autoCount;
		this.manual = manual;
	}

	public static Purchase of(Money money, PurchaseCount manualCount, Lottos manualLottos) {
		Money remainMoney = money.use(Money.of(Lotto.COST, Count.from(manualCount.getValue())));
		PurchaseCount autoCount = remainMoney.purchaseableCount(Money.of(Lotto.COST));

		return new Purchase(autoCount, new Manual(manualCount, manualLottos));
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
