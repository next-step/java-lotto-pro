package lotto.model;

import util.NumberUtil;

public final class UserMoney {
	private static final int LOTTO_PRICE = 1000;
	private int money;

	public UserMoney(String money) {
		validation(money);
		this.money = Integer.parseInt(money);
	}

	public int getMoney() {
		return this.money;
	}

	public int useMoney() {
		return canBuyLotto() * LOTTO_PRICE;
	}

	public int canBuyLotto() {
		return this.money / LOTTO_PRICE;
	}

	private void validation(String money) {
		if (!NumberUtil.isNumber(money)) {
			throw new IllegalArgumentException(String.format("nubmer: %d 숫자가 아닙니다.", money));
		}

		if (!isRange(Integer.parseInt(money))) {
			throw new IllegalArgumentException(
					String.format("nubmer: %d %d보다 작은 수가 입력되었습니다.", Integer.parseInt(money), LOTTO_PRICE));
		}
	}

	private boolean isRange(int money) {
		return money >= LOTTO_PRICE;
	}
}
