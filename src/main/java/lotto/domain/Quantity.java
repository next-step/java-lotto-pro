package lotto.domain;

public class Quantity {
	private int totalLottoQuantity;

	public void plus() {
		totalLottoQuantity++;
	}

	public int value() {
		return totalLottoQuantity;
	}
}
