package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottosTest {

	@Test
	void 로또의_갯수를_알려준다() {
		Lottos lottos = new Lottos(
			Arrays.asList(
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6), LottoType.MANUAL),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6), LottoType.MANUAL)
			)
		);

		assertThat(lottos.countByType(LottoType.AUTO)).isEqualTo(4L);
		assertThat(lottos.countByType(LottoType.MANUAL)).isEqualTo(2L);
	}

	@Test
	void 로또_구입_총비용_계산(){
		Lottos lottos = new Lottos(
			Arrays.asList(
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6), LottoType.MANUAL),
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6), LottoType.MANUAL)
			)
		);
		assertThat(lottos.getTotalSpent()).isEqualTo(new Money(6000L));
	}

}
