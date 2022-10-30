package lotto.domain;

public interface WinningLottoStrategy {
	boolean isWinning(Lotto lotto);

	String matchResultMessage(Lottos lottos);
}
