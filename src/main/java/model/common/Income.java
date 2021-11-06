package model.common;

import java.math.BigDecimal;

import utility.Assert;

public final class Income {

	private final Money lottoPrice;
	private final int purchaseCount;
	private final Money prizeMoney;

	private Income(Money lottoPrice, int purchaseCount, Money prizeMoney) {
		Assert.notNull(lottoPrice, "'lottoPrice' must not be null");
		Assert.notNull(prizeMoney, "'prizeMoney' must not be null");
		Assert.isTrue(positive(purchaseCount), "'purchaseCount' must be positive");
		this.lottoPrice = lottoPrice;
		this.purchaseCount = purchaseCount;
		this.prizeMoney = prizeMoney;
	}

	public static Income of(Money lottoPrice, int purchaseCount, Money prizeMoney) {
		return new Income(lottoPrice, purchaseCount, prizeMoney);
	}

	public BigDecimal ratio() {
		return prizeMoney.ratio(lottoPrice.multiply(purchaseCount));
	}

	@Override
	public String toString() {
		return "Income{" +
			"lottoPrice=" + lottoPrice +
			", purchaseCount=" + purchaseCount +
			", prizeMoney=" + prizeMoney +
			'}';
	}

	private boolean positive(int purchaseCount) {
		return purchaseCount > 0;
	}
}
