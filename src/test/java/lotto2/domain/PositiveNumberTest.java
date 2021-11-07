package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 10, 1234})
	@DisplayName("숫자를 통해 생성할 수 있다")
	public void ofTest(int inputNumber) {
		// when
		PositiveNumber number = PositiveNumber.of(inputNumber);

		// then
		assertThat(number).isEqualTo(PositiveNumber.of(inputNumber));
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -1000})
	public void ofValidateTest(int inputNumber) {
		// when, then
		assertThatThrownBy(() -> PositiveNumber.of(inputNumber))
			.isInstanceOf(IllegalArgumentException.class);

	}
}
