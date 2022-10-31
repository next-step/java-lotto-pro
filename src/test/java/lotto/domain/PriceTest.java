package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceTest {
	@Test
	void 객체_생성() {
		assertThat(Price.from(5000L)).isEqualTo(Price.from(5000L));
	}

}
