package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("splitAndSum_null_또는_빈문자")
	void null_or_empty_parameter_return_0(String strNumber) {
		Number number = new Number(strNumber);

		assertThat(number.equals(new Number(0))).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "ab", "!@", "-5"})
	@DisplayName("유효하지 않은 숫자 입력")
	void valid_negative(String number) {
		assertThatThrownBy(() -> new Number(number))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
