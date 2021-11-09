package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class WinningLottoTest {
	private WinningLotto winningLotto;

	@BeforeEach
	void setUp() {
		Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		int bonusNumber = 7;

		winningLotto = new WinningLotto(lotto, bonusNumber);
	}

	@Test
	@DisplayName("보너스 번호가 이미 당첨 번호에 포함되어 있으면 예외가 발생한다.")
	void testInvalid() {
		Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));
		int bonusNumber = 7;

		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new WinningLotto(lotto, bonusNumber))
			.withMessage(WinningLotto.BONUS_NUMBER_NOT_CORRECT);
	}

	@Test
	@DisplayName("당첨 확인")
	void testRankMatchCreate() {
		Lotto first = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto second = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));
		Lotto third = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 8));
		Lotto fourth = Lotto.from(Arrays.asList(1, 2, 3, 4, 9, 10));
		Lotto fifth = Lotto.from(Arrays.asList(1, 2, 3, 11, 12, 13));
		Lotto loss = Lotto.from(Arrays.asList(21, 22, 23, 24, 25, 26));

		assertAll(
			() -> assertThat(winningLotto.match(first)).isEqualTo(Rank.FIRST),
			() -> assertThat(winningLotto.match(second)).isEqualTo(Rank.SECOND),
			() -> assertThat(winningLotto.match(third)).isEqualTo(Rank.THIRD),
			() -> assertThat(winningLotto.match(fourth)).isEqualTo(Rank.FOURTH),
			() -> assertThat(winningLotto.match(fifth)).isEqualTo(Rank.FIFTH),
			() -> assertThat(winningLotto.match(loss)).isEqualTo(Rank.LOSS)
		);
	}
}
