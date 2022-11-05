package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.domain.quantity.Quantity;

class LottosTest {
	@Test
	void 로또_결과_변환() {
		Lottos lottos = Lottos.from(Arrays.asList(
			Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
			Lotto.from(Arrays.asList(2, 3, 4, 5, 6, 7)),
			Lotto.from(Arrays.asList(3, 4, 5, 6, 7, 8))
		));
		Lotto winLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = LottoNumber.from(7);

		LottoResults lottoResults = lottos.toLottoResults(winLotto, bonusNumber);
		assertThat(lottoResults).isNotNull();
		assertThat(lottoResults.quantity()).isEqualTo(Quantity.from(3));
	}

	@Test
	void concat() {
		Lottos lottos1 = Lottos.from(Arrays.asList(
			Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6))
		));

		Lottos lottos2 = Lottos.from(Arrays.asList(
			Lotto.from(Arrays.asList(2, 3, 4, 5, 6, 7)),
			Lotto.from(Arrays.asList(3, 4, 5, 6, 7, 8))
		));

		assertThat(lottos1.concat(lottos2))
			.isEqualTo(Lottos.from(Arrays.asList(
				Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
				Lotto.from(Arrays.asList(2, 3, 4, 5, 6, 7)),
				Lotto.from(Arrays.asList(3, 4, 5, 6, 7, 8))
			)));
	}
}
