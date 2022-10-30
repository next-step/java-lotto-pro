package lotto.domain;

public class NumberMatchWinningLottoStrategy implements WinningLottoStrategy {
	private final WinningCheckStrategy winningCheckStrategy;
	private final ResultMessageStrategy resultMessageStrategy;

	public NumberMatchWinningLottoStrategy(WinningCheckStrategy winningCheckStrategy,
		ResultMessageStrategy resultMessageStrategy) {
		this.winningCheckStrategy = winningCheckStrategy;
		this.resultMessageStrategy = resultMessageStrategy;
	}

	@Override
	public boolean isWinning(Lotto lotto) {
		return winningCheckStrategy.winningCheck(lotto);
	}

	@Override
	public String matchResultMessage(Lottos lottos) {
		return resultMessageStrategy.resultMessage(lottos.winningQuantity(this));
	}
}
