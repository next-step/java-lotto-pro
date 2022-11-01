package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.domain.amount.Amount;
import lotto.domain.quantity.Quantity;

class LottosTest {
	@Test
	void 로또_15000원어치_구매() {
		assertThat(Lottos.purchase(Amount.from(15000)).getQuantity()).isEqualTo(Quantity.from(15));
	}

	@Test
	void 로또_결과_변환() {
		Lottos lottos = Lottos.from(Arrays.asList(
			Lotto.random(),
			Lotto.random(),
			Lotto.random()
		));
		Lotto winLotto = Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

		LottoResults lottoResults = lottos.toLottoResults(winLotto);
		assertThat(lottoResults).isNotNull();
		assertThat(lottoResults.quantity()).isEqualTo(Quantity.from(3));
	}
}
