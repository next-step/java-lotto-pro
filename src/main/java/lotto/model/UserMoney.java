package lotto.model;

import util.NumberUtil;

public class UserMoney {
	private static final int MIN_MONEY = 0;
	private int money;

	public UserMoney(String money) {
		validation(money);
		this.money = Integer.parseInt(money);
	}

	public int getMoney() {
		return this.money;
	}
	
	public void buyLotto(int lottoPrice) {
		this.money -= lottoPrice;
	}

	private void validation(String money) {
		if (!NumberUtil.isNumber(money)) {
			throw new IllegalArgumentException(String.format("nubmer: %d 숫자가 아닙니다.", money));
		}

		if (!isRange(Integer.parseInt(money))) {
			throw new IllegalArgumentException(
					String.format("nubmer: %d %d보다 작은 수가 입력되었습니다.", Integer.parseInt(money), MIN_MONEY));
		}
	}

	private boolean isRange(int money) {
		return money >= MIN_MONEY;
	}
}
