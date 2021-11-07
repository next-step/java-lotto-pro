package model;

public class Manual {
	private PurchaseCount count;

	private Lottos lottos;

	public Manual(PurchaseCount count, Lottos lottos) {
		this.count = count;
		this.lottos = lottos;
	}

	public PurchaseCount getCount() {
		return count;
	}

	public Lottos getLottos() {
		return lottos;
	}
}
