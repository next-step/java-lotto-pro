package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {
	@DisplayName("음수로 값 객체 생성시 RuntimeException 반환")
	@Test
	void from_Negative_runtimeException() {
		assertThatThrownBy(() -> Number.from(-1))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("음수일 수 없습니다.");
	}

	@DisplayName("더하기")
	@Test
	void sum() {
		assertThat(Number.from(3).sum(Number.from(5))).isEqualTo(Number.from(8));
	}
}