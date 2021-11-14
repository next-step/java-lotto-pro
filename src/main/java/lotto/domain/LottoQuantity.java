package lotto.domain;

import java.util.Objects;

public class LottoQuantity {
	private final Quantity manualQuantity;
	private final Quantity autoQuantity;

	public LottoQuantity(int purchaseQuantity, int manualQuantity) {
		this.manualQuantity = new Quantity(manualQuantity);
		this.autoQuantity = new Quantity(purchaseQuantity - manualQuantity);
	}

	public int getManualQuantity() {
		return manualQuantity.getQuantity();
	}

	public int getAutoQuantity() {
		return autoQuantity.getQuantity();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoQuantity that = (LottoQuantity)o;
		return Objects.equals(manualQuantity, that.manualQuantity) && Objects.equals(autoQuantity,
			that.autoQuantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(manualQuantity, autoQuantity);
	}
}
