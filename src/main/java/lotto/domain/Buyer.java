package lotto.domain;

import java.util.Objects;

public class Buyer {
	private final PurchaseAmount purchaseAmount;
	private final Lottos lottos;

	public Buyer(PurchaseAmount purchaseAmount, Lottos lottos) {
		this.purchaseAmount = purchaseAmount;
		this.lottos = lottos;
	}

	public double getAmount() {
		return purchaseAmount.getAmount();
	}

	public Lottos getLottos() {
		return lottos;
	}

	public WinningRecord match(WinningLotto winningLotto) {
		return winningLotto.match(lottos);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Buyer buyer = (Buyer)o;
		return Objects.equals(purchaseAmount, buyer.purchaseAmount) && Objects.equals(lottos,
			buyer.lottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchaseAmount, lottos);
	}
}
