package lotto.model;

import util.NumberUtil;

public class UserMoney {
	private final int money;

	public UserMoney(String money, int lottoPrice) {
		validation(money, lottoPrice);
		this.money = Integer.parseInt(money);
	}

	public int getMoney() {
		return this.money;
	}

	private void validation(String money, int lottoPrice) {
		if (!NumberUtil.isNumber(money)) {
			throw new IllegalArgumentException(String.format("nubmer: %d 숫자가 아닙니다.", money));
		}

		if (!isRange(Integer.parseInt(money), lottoPrice)) {
			throw new IllegalArgumentException(
					String.format("nubmer: %d %d보다 작은 수가 입력되었습니다.", Integer.parseInt(money), lottoPrice));
		}
	}

	private boolean isRange(int money, int lottoPrice) {
		return money >= lottoPrice;
	}
}
