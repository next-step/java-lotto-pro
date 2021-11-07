package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

	@Test
	@DisplayName("같은 값을 생성할 경우 캐시된 객체인지 검사")
	void 생성() {
		LottoNumber lottoNumber = LottoNumber.of("1");
		assertThat(LottoNumber.of(1)).isEqualTo(lottoNumber);
		assertThat(LottoNumber.of(1) == lottoNumber).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	@DisplayName("범위가 벗어나는 경우 예외 발생")
	void 범위를_벗어나는_숫자(int number) {
		assertThatIllegalArgumentException().isThrownBy(() ->
			LottoNumber.of(number)
		);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	@DisplayName("범위가 벗어나는 경우 유효성 검사 false")
	void 범위가_벗어나는_숫자_유효성_검사(int number) {
		boolean result = LottoNumber.isValidNumber(number);

		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 35, 45})
	@DisplayName("범위 안의 숫자 유효성 검사 true")
	void 범위_안의_숫자_유효성_검사(int number) {
		boolean result = LottoNumber.isValidNumber(number);

		assertThat(result).isTrue();
	}
}