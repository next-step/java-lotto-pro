package lotto;

import org.junit.jupiter.api.Test;
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

	@Test
	void 숫자_2는1보다크다() {
		Number one = new Number(1);
		Number two = new Number(2);
		assertThat(two).isGreaterThan(one);
	}

	@Test
	void 숫자_1은2보다작다() {
		Number one = new Number(1);
		Number two = new Number(2);
		assertThat(one).isLessThan(two);
	}

	@Test
	void 숫자_1은1과같다() {
		Number one = new Number(1);
		assertThat(one).isEqualTo(one);
	}
}
