package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinningPriceTest {
	@Test
	void 객체_생성() {
		assertThat(WinningPrice.from(MatchCount.from(3))).isEqualTo(WinningPrice.from(MatchCount.from(3)));
	}

}
