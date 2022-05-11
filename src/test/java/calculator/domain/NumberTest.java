package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
	@Test
	@DisplayName("splitAndSum_null_또는_빈문자")
	void null_or_empty_parameter_return_0() {
		Number number1 = new Number(null);
		Number number2 = new Number("");

		assertThat(number1.isEqualTo(0)).isTrue();
		assertThat(number2.isEqualTo(0)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "ab", "!@", "-5"})
	@DisplayName("유효하지 않은 숫자 입력")
	void valid_negative(String number) {
		assertThatThrownBy(() -> new Number(number))
			.isInstanceOf(RuntimeException.class);
	}
}