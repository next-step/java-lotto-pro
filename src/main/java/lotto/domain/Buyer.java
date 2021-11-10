package lotto.domain;

import java.util.Objects;

public class Buyer {
	public static final String ERROR_SHORT_MONEY = "구입금액이 부족합니다.";
	private final PurchaseAmount purchaseAmount;
	private final int manual;

	public Buyer(PurchaseAmount purchaseAmount, int manual) {
		this.purchaseAmount = purchaseAmount;
		this.manual = manual;
		validation();
	}

	private void validation() {
		if(isShortMoney()){
			throw new IllegalArgumentException(ERROR_SHORT_MONEY);
		}
	}

	private boolean isShortMoney() {
		return purchaseAmount.isShortMoney(manual);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Buyer buyer = (Buyer)o;
		return manual == buyer.manual && Objects.equals(purchaseAmount, buyer.purchaseAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchaseAmount, manual);
	}
}
