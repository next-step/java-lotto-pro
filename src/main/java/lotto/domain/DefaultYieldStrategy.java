package lotto.domain;

public class DefaultYieldStrategy implements YieldStrategy {
	private final Amount totalWinningPrice;
	private final Amount purchaseAmount;

	public DefaultYieldStrategy(Amount totalWinningPrice, Amount purchaseAmount) {
		this.totalWinningPrice = totalWinningPrice;
		this.purchaseAmount = purchaseAmount;
	}

	@Override
	public Yield yield() {
		validateCanDiv(purchaseAmount);
		return Yield.from((float)totalWinningPrice.getLong() / purchaseAmount.getLong());
	}

	private void validateCanDiv(Amount purchaseAmount) {
		if (purchaseAmount.getLong() == 0) {
			throw new IllegalStateException("수익률 계산에 실패하였습니다. - 0으로 나눌수 없음.");
		}
	}
}
