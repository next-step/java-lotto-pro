package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuantityTest {
	@DisplayName("음수 값 체크")
	@Test
	void validQuantiy() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Quantity(-1))
			.withMessageMatching("구매가능한 로또 수량을 초과하였습니다.");
	}
}
