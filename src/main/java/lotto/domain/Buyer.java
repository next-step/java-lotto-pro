package lotto.domain;

import java.util.Objects;

public class Buyer {
	public static final String ERROR_SHORT_MONEY = "구입금액이 부족합니다.";
	private final PurchaseAmount purchaseAmount;
	private final ManualNumber manualNumber;

	public Buyer(PurchaseAmount purchaseAmount, ManualNumber manualNumber) {
		this.purchaseAmount = purchaseAmount;
		this.manualNumber = manualNumber;
		validation();
	}

	private void validation() {
		if(purchaseAmount.isShortMoney(manualNumber)){
			throw new IllegalArgumentException(ERROR_SHORT_MONEY);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Buyer buyer = (Buyer)o;
		return Objects.equals(purchaseAmount, buyer.purchaseAmount) && Objects.equals(manualNumber,
			buyer.manualNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchaseAmount, manualNumber);
	}
}
