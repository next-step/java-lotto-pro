package lotto.model;

import lotto.constants.LottoConstants;

public class PurchaseMoney {
	private final int money;

	public PurchaseMoney(int money) {
		if (money < 1000) {
			throw new IllegalArgumentException("money is scarce.");
		}
		this.money = money;
	}

	public PurchaseMoney(String money) {
		this(Integer.parseInt(money));
	}

	public int getMoney() { // getter를 없앨 좋을 방법이 있을까요?
		return money;
	}

	public int purchase() {
		return money / LottoConstants.PRICE;
	}
}
