package lotto.domain;

public class MatchResult {
	private final WinningLottoStrategy winningLottoStrategy;
	private final Lottos lottos;

	public MatchResult(WinningLottoStrategy winningLottoStrategy, Lottos lottos) {
		this.winningLottoStrategy = winningLottoStrategy;
		this.lottos = lottos;
	}

	@Override
	public String toString() {
		return winningLottoStrategy.matchResultMessage(lottos);
	}
}
