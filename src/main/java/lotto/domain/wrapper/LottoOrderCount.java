package lotto.domain.wrapper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoOrderCount {
	private final int orderCount;

	public LottoOrderCount(LottoMoney money) {
		this.orderCount = money.get()
			.divide(new BigDecimal(LottoTicket.PRICE), RoundingMode.CEILING)
			.intValue();
	}

	public LottoOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int get() {
		return this.orderCount;
	}
}
