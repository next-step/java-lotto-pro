package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lotto.domain.quantity.Quantity;

class LottosTest {

	@Test
	void 객체_생성() {
		Assertions.assertThat(Lottos.from(Collections::emptyList)).isEqualTo(Lottos.from((Collections::emptyList)));
	}

	@Test
	void 갯수_반환() {
		List<Lotto> lottos = Arrays.asList(Lotto.random(), Lotto.random(), Lotto.random());
		assertThat(Lottos.from(() -> lottos).getQuantity()).isEqualTo(Quantity.from(3));
	}

	@Test
	void 로또_결과_변환() {
		Lottos lottos = Lottos.from(() -> Arrays.asList(
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
