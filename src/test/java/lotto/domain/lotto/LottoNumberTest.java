package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 20, 45})
	void 객체_생성(final int number) {
		Assertions.assertThat(LottoNumber.from(number)).isEqualTo(LottoNumber.from(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {-5, -1, 46, 90})
	void 로또_번호_범위_제한(final int number) {
		assertThatThrownBy(() -> LottoNumber.from(number))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또_번호_반환() {
		assertThat(LottoNumber.from(1).getInt()).isEqualTo(1);
	}
}
