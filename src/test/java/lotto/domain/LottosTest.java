package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class LottosTest {

	@Test
	void 객체_생성() {
		assertThat(Lottos.from(Collections::emptyList)).isEqualTo(Lottos.from((Collections::emptyList)));
	}

	@Test
	void 갯수_반환() {
		List<Lotto> lottos = Arrays.asList(Lotto.random(), Lotto.random(), Lotto.random());
		assertThat(Lottos.from(() -> lottos).getQuantity()).isEqualTo(3);
	}
}
