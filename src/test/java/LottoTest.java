import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

	@Test
	public void of() {
		assertThat(Lotto.of().getNumOfLottoNumbers())
			.isEqualTo(Lotto.NUM_OF_LOTTO_NUMBERS);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2", "1,1,2,3,4,5"})
	public void from_tooShort_duplicated(String input) {
		assertThatExceptionOfType(LottoFormatException.class)
			.isThrownBy(() -> Lotto.from(input))
			.withMessage(LottoFormatException.ERROR_MESSAGE);
	}
}
