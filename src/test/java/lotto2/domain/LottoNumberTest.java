package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 23, 45})
	@DisplayName("1~45번호로 생성되어야 한다")
	public void ofTest(int number) {
		// when
		LottoNumber lottoNumber = LottoNumber.of(number);

		// then
		assertThat(lottoNumber).isEqualTo(LottoNumber.of(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46, 100})
	@DisplayName("1~45 번호 외에는 생성할 수 없다")
	public void ofValidateTest(int number) {
		// when, then
		assertThatThrownBy(() -> LottoNumber.of(number))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
