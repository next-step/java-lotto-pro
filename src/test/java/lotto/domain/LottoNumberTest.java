package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.exception.LottoNumberOutOfRangeException;

class LottoNumberTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 20, 45})
	@DisplayName("허용 범위 이내의 숫자를 전달하여 생성할 수 있다.")
	public void testLottoNumber(int input) {
		LottoNumber lottoNumber = LottoNumber.from(input);
		assertThat(lottoNumber.number()).isEqualTo(input);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 46, -1})
	@DisplayName("허용 범위를 벗어나는 숫자를 전달하면 예외가 발생한다.")
	public void testNotAllowedNumber(int input) {
		assertThatExceptionOfType(LottoNumberOutOfRangeException.class)
			.isThrownBy(() -> LottoNumber.from(input));

		assertThatThrownBy(() -> LottoNumber.from(input))
			.isInstanceOf(LottoNumberOutOfRangeException.class);
	}
}