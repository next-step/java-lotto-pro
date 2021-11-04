package model;

import java.math.BigDecimal;

public final class Income {

	private final Money lottoPrice;
	private final int purchaseCount;
	private final Money prizeMoney;

	private Income(Money lottoPrice, int purchaseCount, Money prizeMoney) {
		validateLottoPrice(lottoPrice);
		validatePurchaseCount(purchaseCount);
		validatePrizeMoney(prizeMoney);
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

	private void validatePrizeMoney(Money prizeMoney) {
		if (prizeMoney == null) {
			throw new IllegalArgumentException("'prizeMoney' must not be null");
		}
	}

	private void validatePurchaseCount(int purchaseCount) {
		if (negative(purchaseCount)) {
			throw new IllegalArgumentException("'purchaseCount' must be positive");
		}
	}

	private boolean negative(int purchaseCount) {
		return purchaseCount < 0;
	}

	private void validateLottoPrice(Money lottoPrice) {
		if (lottoPrice == null) {
			throw new IllegalArgumentException("'lottoPrice' must not be null");
		}
	}
}
