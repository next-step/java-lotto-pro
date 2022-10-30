package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberMatchWinningLottoStrategyTest {
	WinningCheckStrategy winningCheckStrategy;
	ResultMessageStrategy resultMessageStrategy;
	WinningLottoStrategy winningLottoStrategy;

	@BeforeEach
	void setup() {
		winningCheckStrategy = new TestWinningCheckStrategy();
		resultMessageStrategy = new TestResultMessageStrategy();
		winningLottoStrategy = new NumberMatchWinningLottoStrategy(winningCheckStrategy, resultMessageStrategy);
	}

	@Test
	void 로또_번호_일치_체크() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
		assertThat(winningLottoStrategy.isWinning(lotto)).isEqualTo(winningCheckStrategy.winningCheck(lotto));
	}

	@Test
	void 로또_결과() {
		Lottos lottos = new Lottos(0);

		assertThat(winningLottoStrategy.matchResultMessage(lottos))
			.isEqualTo(resultMessageStrategy.resultMessage(0));
	}
}
