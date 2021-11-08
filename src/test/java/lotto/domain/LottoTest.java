package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	@DisplayName("Lotto 번호의 숫자가 6개가 아니면 예외가 발생한다.")
	void testLottoNumberCount() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5)))
			.withMessage(Lotto.NUMBER_COUNT_ERROR);

		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
			.withMessage(Lotto.NUMBER_COUNT_ERROR);
	}

	@Test
	@DisplayName("중복된 번호가 포함된 경우 예외가 발생한다.")
	void testLottoNotAllowedDuplicate() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 5)))
			.withMessage(Lotto.DUPLICATED_NUMBER_ERROR);
	}

	@Test
	@DisplayName("다른 로또와 일치하는 개수를 반환한다.")
	void testWinningMatchCount() {
		Lotto lotto1 = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = Lotto.from(Arrays.asList(1, 2, 3, 7, 8, 9));

		assertThat(lotto1.countMatch(lotto2)).isEqualTo(3);
	}
}