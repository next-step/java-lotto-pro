package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
	@ParameterizedTest
	@CsvSource(value = {"5000,5", "14000,14"})
	void 여러장_구입(int charge, int expected) {
		Lottos lottos = Lottos.buy(new LottoCharge(charge));
		assertThat(lottos.count()).isEqualTo(expected);
	}
}
