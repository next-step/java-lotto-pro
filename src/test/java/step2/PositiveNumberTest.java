package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

	@Test
	void from() {
		assertThat(PositiveNumber.from("1").get()).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(strings = {"NaN", "-1"})
	void from_PositiveNumberFormatException(String input) {
		assertThatExceptionOfType(PositiveNumberFormatException.class)
			.isThrownBy(() -> PositiveNumber.from(input))
			.withMessage(PositiveNumberFormatException.ERROR_MESSAGE);
	}
}
