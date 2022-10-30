package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class NumberMatchWinningCheckStrategyTest {
	@Test
	void 로또_번호_3개_일치() {
		WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		NumberMatchWinningCheckStrategy numberMatchWinningCheckStrategy = new NumberMatchWinningCheckStrategy(
			winningLotto, 3);

		assertThat(numberMatchWinningCheckStrategy.winningCheck(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)))).isTrue();
		assertThat(numberMatchWinningCheckStrategy.winningCheck(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isFalse();
	}
}
