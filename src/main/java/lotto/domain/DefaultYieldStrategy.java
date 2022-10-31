package lotto.domain;

public class DefaultYieldStrategy implements YieldStrategy {
	private final Price totalWinningPrice;
	private final Price purchaseAmount;

	public DefaultYieldStrategy(Price totalWinningPrice, Price purchaseAmount) {
		this.totalWinningPrice = totalWinningPrice;
		this.purchaseAmount = purchaseAmount;
	}

	@Override
	public Yield yield() {
		validateCanDiv(purchaseAmount);
		return Yield.from((float)totalWinningPrice.getLong() / purchaseAmount.getLong());
	}

	private void validateCanDiv(Price purchaseAmount) {
		if (purchaseAmount.getLong() == 0) {
			throw new IllegalStateException("수익률 계산에 실패하였습니다. - 0으로 나눌수 없음.");
		}
	}
}
