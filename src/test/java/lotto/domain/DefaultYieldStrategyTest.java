package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DefaultYieldStrategyTest {

	@Test
	void 수익률_15배() {
		assertThat(new DefaultYieldStrategy(Price.from(15000), Price.from(1000)).yield()).isEqualTo(Yield.from(15));
	}

	@Test
	void 구매비용_0원_IllegalStateException() {
		assertThatThrownBy(() -> new DefaultYieldStrategy(Price.from(15000), Price.from(0)).yield())
			.isInstanceOf(IllegalStateException.class);
	}
}
