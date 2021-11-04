package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.utils.MessageBuilder;

class LottoNumberTest {

	@DisplayName("로또 숫자는 1~45 사이의 숫자로 구성된다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 23, 44, 45})
	void createLottoNumber1(int number) {
		// when
		LottoNumber lottoNumber = LottoNumber.of(number);

		// then
		assertThat(lottoNumber.getNumber()).isGreaterThanOrEqualTo(LOTTO_NUMBER_MIN);
		assertThat(lottoNumber.getNumber()).isLessThanOrEqualTo(LOTTO_NUMBER_MAX);
	}

	@DisplayName("로또 숫자가 1~45 범위를 넘어가면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(ints = {-10, -1, 0, 46, 100})
	void createLottoNumber2(int number) {
		// when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.of(number))
			.withMessage(MessageBuilder.build(INVALID_LOTTO_NUMBER, number));
	}
}