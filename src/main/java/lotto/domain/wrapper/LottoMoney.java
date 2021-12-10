package lotto.domain.wrapper;

import java.math.BigDecimal;

public class LottoMoney {
	private static final String MESSAGE_WRONG_MIN_ORDER = "로또의 금액은 1,000원으로, 최소 1개 이상 구매하셔야합니다.";
	private static final String MESSAGE_WRONG_ORDER_TYPE = "올바르지 않는 구매 요청입니다.";

	private final Money money;

	public LottoMoney(Money money) {
		this.money = validate(money);
	}

	public LottoMoney(String money) {
		this.money = validate(new Money(Integer.valueOf(money)));
	}

	public LottoMoney(int money) {
		this.money = validate(new Money(money));
	}

	public static Money validate(Money money) {
		try {
			return validatedLottoPrice(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_WRONG_ORDER_TYPE);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(MESSAGE_WRONG_MIN_ORDER);
		}
	}

	private static Money validatedLottoPrice(Money money) {
		if (money.get().intValue() < LottoTicket.PRICE) {
			throw new IllegalArgumentException(MESSAGE_WRONG_MIN_ORDER);
		}
		return money;
	}

	public BigDecimal get() {
		return this.money.get();
	}
}
