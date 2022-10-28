package lotto;

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
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6))
			)
		);

		assertThat(lottos.size()).isEqualTo(4);
	}

}
