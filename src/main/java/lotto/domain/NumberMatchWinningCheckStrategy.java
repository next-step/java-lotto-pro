package lotto.domain;

public class NumberMatchWinningCheckStrategy implements WinningCheckStrategy {
	private final WinningLotto winningLotto;
	private final int matchCount;

	public NumberMatchWinningCheckStrategy(WinningLotto winningLotto, int matchCount) {
		this.winningLotto = winningLotto;
		this.matchCount = matchCount;
	}

	@Override
	public boolean winningCheck(Lotto lotto) {
		return winningLotto.matchCount(lotto) == matchCount;
	}
}
