package lotto.domain.wrapper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoOrderCount {
	private static final String MESSAGE_WRONG_ORDER_COUNT = "티켓 구매 수량은 양수만 가능합니다.";
	private static final int MINIMUM_ORDER_COUNT = 0;
	private final int orderCount;

	public LottoOrderCount() {
		this.orderCount = 0;
	}

	public LottoOrderCount(LottoMoney money) {
		this.orderCount = money.get()
			.divide(new BigDecimal(LottoTicket.PRICE), RoundingMode.CEILING)
			.intValue();
	}

	public LottoOrderCount(int orderCount) {
		if (orderCount < MINIMUM_ORDER_COUNT) {
			throw new IllegalArgumentException(MESSAGE_WRONG_ORDER_COUNT);
		}
		this.orderCount = orderCount;
	}

	public int get() {
		return this.orderCount;
	}
}
