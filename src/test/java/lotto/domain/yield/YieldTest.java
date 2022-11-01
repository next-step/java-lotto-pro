package lotto.domain.yield;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.yield.Yield;

class YieldTest {
	@Test
	void 객체_생성() {
		assertThat(Yield.from(1f)).isEqualTo(Yield.from(1f));
	}

	@Test
	void 크기_비교() {
		assertThat(Yield.from(1f).isGreaterThan(Yield.from(0.5f))).isTrue();
	}

}
