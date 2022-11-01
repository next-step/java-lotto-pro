package lotto.domain.quantity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuantityTest {
	@Test
	void 객체_생성() {
		assertThat(Quantity.from(3)).isEqualTo(Quantity.from(3));
	}

	@Test
	void 갯수_0_미만_불가() {
		assertThatThrownBy(() -> Quantity.from(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
