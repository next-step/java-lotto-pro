package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class NumberMatchWinningLottoStrategyTest {
	@Test
	void 로또_번호_3개_일치() {
		WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoStrategy winningLottoStrategy = new NumberMatchWinningLottoStrategy(winningLotto, 3, 5000);

		assertThat(winningLottoStrategy.isWinning(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)))).isTrue();
		assertThat(winningLottoStrategy.isWinning(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isFalse();
	}

	@Test
	void 로또_결과() {
		WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLottoStrategy winningLottoStrategy = new NumberMatchWinningLottoStrategy(winningLotto, 3, 5000);
		Lottos lottos = new Lottos(0);

		// TODO 파라미터 갯수 줄이기
		assertThat(winningLottoStrategy.matchResultMessage(lottos)).isEqualTo(
			String.format("%d개 일치 (%d원)- %d개", 3, 5000, 0));
	}
}
