import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 23, 45})
	public void from(int number) {
		assertThat(LottoNumber.from(number).get()).isEqualTo(number);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	public void from_LottoNumberFormatException(int number) {
		assertThatExceptionOfType(LottoNumberFormatException.class)
			.isThrownBy(() -> LottoNumber.from(number))
			.withMessage(LottoNumberFormatException.ERROR_MESSAGE);
	}
}
