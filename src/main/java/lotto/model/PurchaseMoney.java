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

	public int purchase() {
		return money / LottoConstants.PRICE;
	}

	public int purchaseWithoutManual(int numberOfManual) {
		int numberOfLottos = purchase();
		if (numberOfLottos < numberOfManual) {
			throw new IllegalArgumentException("money is scarce.");
		}
		return numberOfLottos - numberOfManual;
	}

	public double divided(double winMoney) {
		return winMoney / money;
	}
}
