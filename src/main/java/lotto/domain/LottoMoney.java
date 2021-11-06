package lotto.domain;

import java.util.Objects;

public class LottoMoney {
	public static final int SALE_PRICE = 1000;
	public static final int CHANGE = 0;
	public static final String REGEX_NUMBER = "[0-9]";

	private final int money;

	public LottoMoney(String amount) {
		if (isNumber(amount)) {
			throw new IllegalArgumentException("숫자만 입력해주세요.");
		}
		this.money = Integer.parseInt(amount);
		if (isAmountCorrect(this.money)) {
			throw new IllegalArgumentException("금액이 정확하지 않습니다.");
		}
	}

	private boolean isAmountCorrect(int amount) {
		return amount % SALE_PRICE != CHANGE;
	}

	private boolean isNumber(String amount) {
		return REGEX_NUMBER.matches(amount);
	}

	public int buyCount() {
		return this.money / SALE_PRICE;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoMoney money1 = (LottoMoney)o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
