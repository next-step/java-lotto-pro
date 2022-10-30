package lotto.domain;

public class NumberMatchWinningLottoStrategy implements WinningLottoStrategy {
	private final WinningLotto winningLotto;
	private final int matchCount;
	private final long matchPrice;

	public NumberMatchWinningLottoStrategy(WinningLotto winningLotto, int matchCount, int matchPrice) {
		this.winningLotto = winningLotto;
		this.matchCount = matchCount;
		this.matchPrice = matchPrice;
	}

	@Override
	public boolean isWinning(Lotto lotto) {
		return winningLotto.matchCount(lotto) == matchCount;
	}

	@Override
	public String matchResultMessage(Lottos lottos) {
		return String.format("%d개 일치 (%d원)- %d개", matchCount, matchPrice, lottos.winningQuantity(this));
	}
}
