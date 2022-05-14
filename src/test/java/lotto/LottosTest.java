package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
	Answer answer123456 = new Answer("1, 2, 3, 4, 5, 6");

	@ParameterizedTest
	@CsvSource(value = {"5000,5", "14000,14"})
	void 여러장_구입(int charge, int expected) {
		Lottos lottos = Lottos.buy(new LottoCharge(charge));
		assertThat(lottos.count()).isEqualTo(expected);
	}

	@Test
	void 당첨금의합() {
		Lottos lottos = new Lottos(Arrays.asList(
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 7),
				new Lotto(1, 2, 3 ,4 ,7, 8),
				new Lotto(1, 2, 3, 7, 8, 9),
				new Lotto(1, 2, 7, 8, 9, 10)
		));
		assertThat(lottos.winnigs(answer123456).totalMoney()).isEqualTo(2000000000 + 1500000 + 50000 + 5000);
	}
}
