package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 20, 45})
	@DisplayName("허용 범위 이내의 숫자를 전달하여 생성할 수 있다.")
	public void testLottoNumber(int input) {
		LottoNumber lottoNumber = new LottoNumber(input);
		assertThat(lottoNumber.number()).isEqualTo(input);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 46, -1})
	@DisplayName("허용 범위를 벗어나는 숫자를 전달하면 예외가 발생한다.")
	public void testNotAllowedNumber(int input) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoNumber(input))
			.withMessage(LottoNumber.OUT_OF_RANGE_ERROR);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoNumber(input))
			.withMessage(LottoNumber.OUT_OF_RANGE_ERROR);
	}
}