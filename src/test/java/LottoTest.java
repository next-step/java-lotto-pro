import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

	@Test
	void from_sort() {
		assertThat(LottoFactory.from("6,5,4,3,2,1").toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2", "1,2,3,4,5,6,7", "1,1,2,3,4,5"})
	void from_tooShort_tooLong_duplicated(String input) {
		assertThatExceptionOfType(LottoFormatException.class)
			.isThrownBy(() -> LottoFactory.from(input))
			.withMessage(LottoFormatException.ERROR_MESSAGE);
	}

	@Test
	void hasBonus() {
		final String bonus = "45";
		final WinningLotto winningLotto = WinningLottoBuilder.aWinningLotto()
			.withLottoNumbers("1,2,3,4,5,6")
			.withBonus(bonus)
			.build();
		assertThat(LottoFactory.from("1,2,3,4,5,6").hasBonus(winningLotto)).isFalse();
		assertThat(LottoFactory.from(String.format("1,2,3,4,5,%s", bonus)).hasBonus(winningLotto)).isTrue();
	}
}
