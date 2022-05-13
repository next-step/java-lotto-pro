package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 45})
	void 숫자_생성(int value) {
		assertThat(new Number(value)).isEqualTo(new Number(value));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	void 숫자_범위를넘어가면예외(int value) {
		assertThatThrownBy(() -> new Number(value))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
