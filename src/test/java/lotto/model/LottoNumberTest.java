package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 테스트")
class LottoNumberTest {

	@DisplayName("로또번호 생성시 1~45 범위의 숫자가 아닌경우 예외처리 테스트")
	@ParameterizedTest(name = "index : {index}, outNumber : {0}")
	@ValueSource(ints = {0, 46, Integer.MAX_VALUE})
	void 로또번호_생성시_1_45범위의_숫자가_아닐경우_예외처리(int outNumber) {
		// given // when // then
		assertThatThrownBy(() -> {
			new LottoNumber(outNumber);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또번호 생성시 랜덤 값으로 생성하는 테스트")
	@Test
	void 랜덤로또번호_생성_테스트() {
		// given // when
		LottoNumber lottoNumber = new LottoNumber();

		// then
		assertThat(lottoNumber.getNumber()).isBetween(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER);
	}

	@DisplayName("로또번호 생성시 number 값을 받아오는 테스트")
	@Test
	void 로또번호_생성시_getNumber_테스트() {
		// given
		int number = 4;

		// when
		LottoNumber lottoNumber = new LottoNumber(number);

		// then
		assertAll(
			() -> assertThat(lottoNumber).isInstanceOf(LottoNumber.class),
			() -> assertThat(lottoNumber.getNumber()).isEqualTo(number)
		);
	}

	@DisplayName("로또번호 비교 테스트")
	@Test
	void 로또번호_비교_테스트() {
		// given
		int number1 = 5;
		int number2 = 4;

		// when
		LottoNumber lottoNumber1 = new LottoNumber(number1);
		LottoNumber lottoNumber2 = new LottoNumber(number1);
		LottoNumber lottoNumber3 = new LottoNumber(number2);

		// then
		assertAll(
			() -> assertThat(lottoNumber1.equals(lottoNumber2)).isTrue(),
			() -> assertThat(lottoNumber1.equals(lottoNumber3)).isFalse()
		);
	}
}