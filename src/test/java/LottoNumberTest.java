import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 23, 45})
	public void of(int number) {
		assertThat(LottoNumber.of(number).get()).isEqualTo(number);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	public void of_LottoNumberFormatException(int number) {
		assertThatExceptionOfType(LottoNumberFormatException.class)
			.isThrownBy(() -> LottoNumber.of(number))
			.withMessage(LottoNumberFormatException.ERROR_MESSAGE);
	}
}
