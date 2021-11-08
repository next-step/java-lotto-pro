import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 23, 45})
	void from(int number) {
		assertThat(LottoNumber.from(number).get()).isEqualTo(number);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	void from_LottoNumberFormatException(int number) {
		assertThatExceptionOfType(LottoNumberFormatException.class)
			.isThrownBy(() -> LottoNumber.from(number))
			.withMessage(LottoNumberFormatException.ERROR_MESSAGE);
	}

	@Test
	void from_String() {
		assertThat(LottoNumber.from("1").get()).isEqualTo(1);

		assertThatExceptionOfType(LottoNumberFormatException.class)
			.isThrownBy(() -> LottoNumber.from(null))
			.withMessage(LottoNumberFormatException.ERROR_MESSAGE);

		assertThatExceptionOfType(LottoNumberFormatException.class)
			.isThrownBy(() -> LottoNumber.from("a"))
			.withMessage(LottoNumberFormatException.ERROR_MESSAGE);
	}
}
