package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DefaultPurchaseStrategyTest {
	@Test
	void 숫자가_아닌_문자열_IllegalArgumentException() {
		assertThatThrownBy(() -> new DefaultPurchaseStrategy("숫자아님").purchase())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 입력_금액_음수_IllegalArgumentException() {
		assertThatThrownBy(() -> new DefaultPurchaseStrategy(-3000).purchase())
			.isInstanceOf(IllegalArgumentException.class);
	}

}
