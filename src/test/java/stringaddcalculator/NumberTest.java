package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

	@DisplayName("더하기")
	@Test
	void sum() {
		assertThat(Number.from(3).sum(Number.from(5))).isEqualTo(Number.from(8));
	}

	@DisplayName("음수 여부 확인")
	@Test
	void isNegative() {
		assertThat(Number.from(3).isNegative()).isFalse();
		assertThat(Number.from(-1).isNegative()).isTrue();
	}
}