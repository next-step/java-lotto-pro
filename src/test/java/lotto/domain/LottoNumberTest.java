package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 20, 45})
	void 객체_생성(final int number) {
		assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {-5, -1, 46, 90})
	void 로또_번호_범위_제한(final int number) {
		assertThatThrownBy(() -> new LottoNumber(number))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
