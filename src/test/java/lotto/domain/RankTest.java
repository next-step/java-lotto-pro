package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RankTest {
	@Test
	@DisplayName("숫자가 일치하는 개수가 유효하지 않을 경우 예외가 발생한다.")
	void testInvalid() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Rank.from(7))
			.withMessage(Rank.MATCH_COUNT_NOT_CORRECT_ERROR);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	@DisplayName("3개 미만의 숫자가 일치하는 경우는 Loss이다")
	void testLoss(int input) {
		assertThat(Rank.from(input)).isEqualTo(Rank.LOSS);
	}

	@Test
	@DisplayName("3개의 숫자가 일치하는 경우 5등이다")
	void testFifth() {
		assertThat(Rank.from(3)).isEqualTo(Rank.FIFTH);
	}

	@Test
	@DisplayName("4개의 숫자가 일치하는 경우 4등이다")
	void testFourth() {
		assertThat(Rank.from(4)).isEqualTo(Rank.FOURTH);
	}

	@Test
	@DisplayName("5개의 숫자가 일치하는 경우 3등이다")
	void testThird() {
		assertThat(Rank.from(5)).isEqualTo(Rank.THIRD);
	}

	@Test
	@DisplayName("6개의 숫자가 일치하는 경우 1등이다.")
	void testFirst() {
		assertThat(Rank.from(6)).isEqualTo(Rank.FIRST);
	}
}
