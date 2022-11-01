package lotto.domain.yield;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lotto.domain.amount.Amount;

class DefaultYieldStrategyTest {

	@Test
	void 수익률_15배() {
		Assertions.assertThat(new DefaultYieldStrategy(Amount.from(15000), Amount.from(1000)).yield()).isEqualTo(Yield.from(15));
	}

	@Test
	void 구매비용_0원_IllegalStateException() {
		assertThatThrownBy(() -> new DefaultYieldStrategy(Amount.from(15000), Amount.from(0)).yield())
			.isInstanceOf(IllegalStateException.class);
	}
}
