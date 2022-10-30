package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchResultTest {
	@Test
	void 로또_결과_반환() {
		TestWinningLottoStrategy winningLottoStrategy = new TestWinningLottoStrategy();
		Lottos lottos = new Lottos(0);
		MatchResult matchResult = new MatchResult(winningLottoStrategy, lottos);
		assertThat(matchResult.toString()).isEqualTo(winningLottoStrategy.matchResultMessage(lottos));
	}
}
