import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {

	@Test
	void winningLotto_invalidBonus() {
		assertThatExceptionOfType(WinningLottoFormatException.class)
			.isThrownBy(() -> new WinningLotto(LottoParser.parse("1,2,3,4,5,6"), LottoNumber.from("1")))
			.withMessage(WinningLottoFormatException.ERROR_MESSAGE);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4,5,6/6", "1,2,3,10,11,12/3", "10,11,12,13,14,15/0"}, delimiter = '/')
	void countMatching(String lotto, int numOfMatching) {
		final WinningLotto winningLotto = WinningLottoBuilder.aWinningLotto()
			.withLottoNumbers("1,2,3,4,5,6")
			.withBonus("45")
			.build();
		assertThat(winningLotto.countMatching(Lotto.from(lotto))).isEqualTo(numOfMatching);
	}
}
