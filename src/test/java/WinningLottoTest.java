import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {

	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4,5,6/6", "1,2,3,10,11,12/3", "10,11,12,13,14,15/0"}, delimiter = '/')
	void countMatching(String lotto, int numOfMatching) {
		final WinningLotto winningLotto = WinningLotto.from("1,2,3,4,5,6");
		assertThat(winningLotto.countMatching(Lotto.from(lotto))).isEqualTo(numOfMatching);
	}
}
