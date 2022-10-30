package lotto.domain;

public class TestWinningLottoStrategy implements WinningLottoStrategy {
	@Override
	public boolean isWinning(Lotto lotto) {
		return false;
	}

	@Override
	public String matchResultMessage(Lottos lottos) {
		return null;
	}
}
